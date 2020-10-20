package edu.chainnet.sc.message;

import org.greatfree.message.multicast.MulticastResponse;

// Created: 10/18/2020, Bing Li
public class RetrieveONNodeUponIDResponse extends MulticastResponse 
{
	private static final long serialVersionUID = 8945776951962401990L;
	
	private DSNode node;

	public RetrieveONNodeUponIDResponse(DSNode node, String collaboratorKey)
	{
		super(SCAppID.RETRIEVE_ON_NODE_UPON_ID_RESPONSE, collaboratorKey);
		this.node = node;
	}

	public DSNode getNode()
	{
		return this.node;
	}
}
