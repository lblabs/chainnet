package edu.chainnet.sc.collaborator.child;

import java.io.IOException;

import org.greatfree.data.ServerConfig;
import org.greatfree.exceptions.RemoteReadException;
import org.greatfree.util.TerminateSignal;

/*
 * The child of the collaboration level is started by the code. 10/17/2020, Bing Li
 */

// Created: 10/17/2020, Bing Li
class StartChild
{

	public static void main(String[] args)
	{
		System.out.println("Collaborator child starting up ...");
		
		try
		{
			CollaboratorChild.BC().start(new CollaboratorChildTask());
		}
		catch (ClassNotFoundException | IOException | RemoteReadException | InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("Collaborator child started ...");

		while (!TerminateSignal.SIGNAL().isTerminated())
		{
			try
			{
				Thread.sleep(ServerConfig.TERMINATE_SLEEP);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
