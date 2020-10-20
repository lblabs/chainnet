package edu.chainnet.sc.message;

import org.greatfree.message.multicast.container.Request;

// Created: 10/18/2020, Bing Li
public class RetrieveDLNodeUponIDRequest extends Request
{
	private static final long serialVersionUID = -1652960064145478279L;
	
	private String nodeKey;

	public RetrieveDLNodeUponIDRequest(String nodeKey)
	{
		super(nodeKey, SCAppID.RETRIEVE_DL_NODE_UPON_ID_REQUEST);
		this.nodeKey = nodeKey;
	}

	public String getNodeKey()
	{
		return this.nodeKey;
	}
}
