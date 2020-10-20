package edu.chainnet.sc.message;

import org.greatfree.message.multicast.container.Request;

// Created: 10/18/2020, Bing Li
public class RetrieveSCNodeUponIDRequest extends Request
{
	private static final long serialVersionUID = 6055977720387710385L;

	private String nodeKey;

	public RetrieveSCNodeUponIDRequest(String nodeKey)
	{
		super(nodeKey, SCAppID.RETRIEVE_SC_NODE_UPON_ID_REQUEST);
		this.nodeKey = nodeKey;
	}

	public String getNodeKey()
	{
		return this.nodeKey;
	}
}
