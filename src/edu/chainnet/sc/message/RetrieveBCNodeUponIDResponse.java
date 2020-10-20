package edu.chainnet.sc.message;

import org.greatfree.message.multicast.MulticastResponse;

// Created: 10/17/2020, Bing Li
public class RetrieveBCNodeUponIDResponse extends MulticastResponse
{
	private static final long serialVersionUID = 4364869988186238124L;
	
	private BCNode node;

	public RetrieveBCNodeUponIDResponse(BCNode node, String collaboratorKey)
	{
		super(SCAppID.RETRIEVE_BC_NODE_UPON_ID_RESPONSE, collaboratorKey);
		this.node = node;
	}

	public BCNode getNode()
	{
		return this.node;
	}
}
