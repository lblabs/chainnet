package edu.chainnet.sc.message;

import org.greatfree.message.multicast.container.Request;

// Created: 10/18/2020, Bing Li
public class RetrieveONNodeUponIDRequest extends Request
{
	private static final long serialVersionUID = 7462705182358927610L;

	private String nodeKey;

	public RetrieveONNodeUponIDRequest(String nodeKey)
	{
		super(nodeKey, SCAppID.RETRIEVE_ON_NODE_UPON_ID_REQUEST);
		this.nodeKey = nodeKey;
	}

	public String getNodeKey()
	{
		return this.nodeKey;
	}
}
