package edu.chainnet.sc.collaborator.child.db;

import java.util.List;

import edu.chainnet.sc.collaborator.ChildPath;
import edu.chainnet.sc.message.BCNode;
import edu.chainnet.sc.message.DSNode;

/*
 * All of sub DBs are enclosed in the singleton. 10/19/2020, Bing Li
 */

// Created: 10/19/2020, Bing Li
public class CollaboratorDB
{
	private BCNodeDB bcDB;
	private DSNodeDB dsDB;
	private HistoryBCNodeDB hBCDB;
	private HistoryDSNodeDB hDSDB;

	private CollaboratorDB()
	{
	}
	
	private static CollaboratorDB instance = new CollaboratorDB();
	
	public static CollaboratorDB BC()
	{
		if (instance == null)
		{
			instance = new CollaboratorDB();
			return instance;
		}
		else
		{
			return instance;
		}
	}

	public void dispose()
	{
		this.bcDB.dispose();
		this.dsDB.dispose();
		this.hBCDB.dispose();
		this.hDSDB.dispose();
	}
	
	public void init(ChildPath path)
	{
		this.bcDB = new BCNodeDB(path.getBCPath());
		this.dsDB = new DSNodeDB(path.getDSPath());
		this.hBCDB = new HistoryBCNodeDB(path.getHistoryBCPath());
		this.hDSDB = new HistoryDSNodeDB(path.getHistoryDSPath());
	}

	/*
	 * The below methods process the latest nodes. 10/19/2020, Bing Li
	 */
	public void saveNode(BCNode node)
	{
		this.bcDB.saveNode(node);
	}
	
	public BCNode getBCNodeByKey(String nodeKey)
	{
		return this.bcDB.getNode(nodeKey);
	}
	
	public List<BCNode> getBCNodesByService(String serviceName)
	{
		return this.bcDB.getNodesByService(serviceName);
	}
	
	public List<BCNode> getBCNodesByDescription(String description)
	{
		return this.bcDB.getNodesByDescription(description);
	}
	
	public void saveNode(DSNode node, int nodeType)
	{
		this.dsDB.saveNode(node, nodeType);
	}
	
	public DSNode getDSNodeByKey(String nodeKey)
	{
		return this.dsDB.getNode(nodeKey);
	}
	
	public List<DSNode> getDSNodesByService(String serviceName, int nodeType)
	{
		return this.dsDB.getNodesByService(serviceName, nodeType);
	}
	
	public List<DSNode> getDSNodesByDescription(String description)
	{
		return this.dsDB.getNodesByDescription(description);
	}

	/*
	 * The below methods process the history nodes. 10/19/2020, Bing Li
	 */
	public void saveHistoryNode(BCNode node)
	{
		this.hBCDB.saveNode(node, this.hBCDB.getVersionSize(node.getKey()));
	}

	public List<BCNode> getHistoryBCNodesByService(String serviceName)
	{
		return this.hBCDB.getNodesByService(serviceName);
	}

	public List<BCNode> getHistoryBCNodesByVersion(int version)
	{
		return this.hBCDB.getNodesByVersion(version);
	}
	
	public List<BCNode> getHistoryBCNodesByDescription(String description)
	{
		return this.hBCDB.getNodesByDescription(description);
	}
	
	public void saveHistoryNode(DSNode node, int nodeType)
	{
		this.hDSDB.saveNode(node, this.hDSDB.getVersionSize(node.getKey(), nodeType), nodeType);
	}
	
	public List<DSNode> getHistoryDSNodesByService(String serviceName, int nodeType)
	{
		return this.hDSDB.getNodesByService(serviceName, nodeType);
	}
	
	public List<DSNode> getHistoryDSNodesByVersion(int version, int nodeType)
	{
		return this.hDSDB.getNodesByVersion(version, nodeType);
	}
	
	public List<DSNode> getHistoryDSNodesByDescription(String description)
	{
		return this.hDSDB.getNodesByDescription(description);
	}
}
