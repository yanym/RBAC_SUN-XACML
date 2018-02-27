package xacml.generator;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.StorageManager;
import json.Role;
import json.Rule;

public class XACMLGenerator {
	private StorageManager manager;
	
	public XACMLGenerator(StorageManager manager){
		this.manager = manager;
	}
	
	public void synchronize() throws SQLException{
			File tomcatDirectory = new File(System.getProperty("catalina.base"));
			File outDir = new File(tomcatDirectory, "_rbacman/policies");
			if(!outDir.exists())
				outDir.mkdirs();
			List<Role> roles = manager.getRoles("id",  -1, -1);
			for(Role role: roles){
				
				String roleName = role.getName();
				Subject subject=  new Subject();
				subject.setSubjectRole(roleName);
				Policy policy = new Policy(subject);
				List<Rule> rules = manager.getRulesByRole(role);
				List<String> resources = new ArrayList<String>();
				for(Rule rule: rules){
					if(rule.isPermit())
						policy.addPermit(rule.getAction().getName());
					else policy.addDeny(rule.getAction().getName());
					
					resources.add(rule.getResource().getUrl());
				}
				
				File policyFile = new File(outDir, roleName + ".xml");
				policy.generate(policyFile, resources);
			}
				
		}

}
