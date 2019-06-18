package edu.handong.csee;

import edu.handong.csee.OpenError;

public class JavaFinalProject {
	
	public void run(String[] args) {

		try {
			if(args.length<5)
				throw new OpenError();
		} catch (OpenError e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

	}
}