package edu.chainnet.sc.message;

import org.greatfree.message.multicast.MulticastResponse;

// Created: 10/18/2020, Bing Li
public class RetrieveSCNodeUponIDResponse extends MulticastResponse
{
	private static final long serialVersionUID = -8435379136546674002L;
	
	private DSNode node;

	public RetrieveSCNodeUponIDResponse(DSNode node, String collaboratorKey)
	{
		super(SCAppID.RETRIEVE_SC_NODE_UPON_ID_RESPONSE, collaboratorKey);
		this.node = node;
	}

	public DSNode getNode()
	{
		return this.node;
	}
}
