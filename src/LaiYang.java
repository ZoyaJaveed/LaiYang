import java.util.*;
class Event {
	private int fromProcess,fromProcessEvent, toProcess,toProcessEvent, amount, sendOrReceive, time,channelID,typeOfMessage;
	private int amountRemaining;
	public Event(){		
		this.fromProcess=0;
		this.fromProcessEvent=0;
		this.toProcess=0;
		this.toProcessEvent=0;
		this.amount=0;
		this.sendOrReceive=0;
		this.time=0;
		this.channelID=0;
		this.typeOfMessage=0;
		this.amountRemaining =0;
	}
	public  void set(int channelID,int sendOrReceive, int typeOfMessage, int time,int fromProcess,int fromProcessEvent, int toProcess,int toProcessEvent,int amount,  int amountRemaining ){
		this.fromProcess=fromProcess;
		this.fromProcessEvent=fromProcessEvent;
		this.toProcess=toProcess;
		this.toProcessEvent=toProcessEvent;
		this.amount=amount;
		this.sendOrReceive= sendOrReceive;
		this.time=time;
		this.channelID=channelID;
		this.typeOfMessage=typeOfMessage;
		this.amountRemaining=amountRemaining;
	}
	
	public int getFromProcess() {
		return this.fromProcess;
	}
	
	public int getFromProcessEvent() {
		return this.fromProcessEvent;
	}
	
	public int getToProcess() {
		return this.toProcess;
	}
	
	public int getToProcessEvent() {
		return this.toProcessEvent;
	}
	
	public int getAmount() {
		return this.amount;
	}
	public int getSendOrReceive() {
		return this.sendOrReceive;
	}
	public int getTime() {
		return this.time;
	}
	public int channelID() {
		return this.channelID;
	}
	public int getTypeMessage() {
		return typeOfMessage;
	}
	public int getAmountRemaining() {
		return amountRemaining;
	}
}
class SnapShot{
	private int processID,snapShotTime, snapShotFlag;
	public SnapShot(){		
		this.processID=0;
		this.snapShotTime=0;
//		this.snapShotFlag=0;
	}
	public  void set(int processID,int snapShotTime){
		this.processID=processID;
		this.snapShotTime=snapShotTime;
//		this.snapShotFlag=snapShotFlag;
	}
	public int getProcessID() {
		return processID;
	}
	public int getSnapShotTime() {
		return snapShotTime;
	}
}
class Global{
	private int processId,processIDLocalSnapShot,whiteMessagesSent,whiteMessagesReceived,subWhiteSentAndReceived;
	
	public Global() {
		this.processId=0;
		this.processIDLocalSnapShot=0;
		this.whiteMessagesSent=0;
		this.whiteMessagesReceived=0;
		this.subWhiteSentAndReceived =0;	
	}
	
	public void set(int processId, int processIDLocalSnapShot,int whiteMessagesSent,int whiteMessagesReceived,int subWhiteSentAndReceived) {
		this.processId=processId;
		this.processIDLocalSnapShot=processIDLocalSnapShot;
		this.whiteMessagesSent=whiteMessagesSent;
		this.whiteMessagesReceived=whiteMessagesReceived;
		this.subWhiteSentAndReceived =subWhiteSentAndReceived;		
	}
	public int getProcessID() {
		return processId;
	}
	public int getProcessIDLocalSnapShot() {
		return processIDLocalSnapShot;
	}
	public int getWhiteMessagesSent() {
		return whiteMessagesSent;
	}
	public int getWhiteMessagesReceived() {
		return whiteMessagesReceived;
	}
	public int getSubWhiteSentAndReceived() {
		return subWhiteSentAndReceived;
	}
}
class Channel{
	private int sendOrReceive,whiteOrRed,fromProcess,toProcess,Amount;
	public Channel() {
		this.sendOrReceive=0;
		this.whiteOrRed=0;
		this.fromProcess=0;
		this.toProcess=0;
		this.Amount=0;
	}
	public void set(int sendOrReceive, int whiteOrRed, int fromProcess, int toProcess,int Amount) {
		this.sendOrReceive=sendOrReceive;
		this.whiteOrRed=whiteOrRed;
		this.fromProcess=fromProcess;
		this.toProcess=toProcess;
		this.Amount=Amount;
	}
	public int getSendOrReceive() {
		return this.sendOrReceive;
	}
	public int getWhiteOrRed() {
		return this.whiteOrRed;
	}

	public int getFromProcess() {
		return this.fromProcess;
	}

	public int getToProcess() {
		return this.toProcess;
	}

	public int getAmount() {
		return this.Amount;
	}

	
}

class Process{
	static int sumAmount =0;
	static int nunberOfProcesses, numberOfEvents[] = new int[100];
	static Event ev[][] = new Event[100][100];
	static Event whiteMessages[][] = new Event[100][100];
	static Global globalSnapShots[] = new Global[100];
	static int localSnapShot[]=new int[100];
	//static int et[][] = new int[100][100];
	static int amount[] = new int[100];
	static SnapShot snapShot[] = new SnapShot[100];
	static int initialTime[]=new int[100];
	static  int amountRemaining[]=new int[100];
	static Channel sendChannel[][] = new Channel[100][100];
	static Channel receiveChannel[][] = new Channel[100][100];
	public void calc(){
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of processes : ");
		nunberOfProcesses = scan.nextInt();
		
		System.out.println("Enter the initial amount in the processes and the initial timestamps : ");
		for(int i=1;i<=nunberOfProcesses;i++) {
			amount[i] = scan.nextInt();
			initialTime[i] =  scan.nextInt();			
		}
			
		System.out.println("Enter the number of events per process : ");
		for(int i = 1; i <= nunberOfProcesses; i++)
			numberOfEvents[i] = scan.nextInt();
			
		System.out.println("Enter the event details per process:Channel ID,Send Or Receive (Send 0, Receive 1),Type of message (White 0, Red 1),Time of Event,FromProcessID,FromProcessEvent,ToProcessID,ToProcessEvent,Amount in message");
		for(int i = 1; i <= nunberOfProcesses; i++){
			ev[i] = new Event[100];
			System.out.println("For Process " + (i));
			
			for(int j = 1; j <= numberOfEvents[i]; j++){
				ev[i][j] = new Event();
				System.out.println("For event " + (j));
				int channelID = scan.nextInt();
				int sendOrReceive=scan.nextInt();
				int typeOfMessage=scan.nextInt();
				int time =scan.nextInt();
				int fromProcess = scan.nextInt();
				int fromProcessEvent=scan.nextInt();
				int toProcess=scan.nextInt();
				int toProcessEvent=scan.nextInt();
				int amountInMessage=scan.nextInt();	
				if(sendOrReceive==0) {
					amountRemaining[j]= (amount[i]-amountInMessage);
				}else {
					amountRemaining[j]= (amount[i]+amountInMessage);
				}
				amount[i]=amountRemaining[j];
				ev[i][j].set(channelID, sendOrReceive,typeOfMessage,time,fromProcess,fromProcessEvent,toProcess,toProcessEvent,amountInMessage,amountRemaining[j]);
				
			}
		}
		
//		System.out.println("For each process enter processId, and time at which snapshot is to be taken for the process");
//		for(int i = 1; i <= nunberOfProcesses; i++){
//			snapShot[i] = new SnapShot[100];
//			System.out.println("For Process " + (i));
//			for(int j=1;j<=2;j++) {
//				snapShot[i][j] = new SnapShot();
//				int snapShotTime = scan.nextInt();
//				snapShot[i][j].set(i, snapShotTime);
//			}
//		}
//		
		System.out.println("We will carry out Snapshot Algorithm now: ");
		
		for(int i = 1; i <= nunberOfProcesses; i++){
			
			System.out.println("For Process " + (i) + " Enter the timestamp ");
			
				snapShot[i] = new SnapShot();
				int snapShotTime = scan.nextInt();
				snapShot[i].set(i, snapShotTime);
			
		}
			
		
		for(int i=1;i<=nunberOfProcesses;i++) {
			for(int j=1;j <= numberOfEvents[i]; j++) {
				System.out.println(ev[i][j].channelID()+ "  " + ev[i][j].getSendOrReceive() + "  " + ev[i][j].getTypeMessage() + "  " + ev[i][j].getTime() + "  " + ev[i][j].getFromProcess() + "  " + ev[i][j].getFromProcessEvent() + "  " + ev[i][j].getToProcess() + "  " + ev[i][j].getToProcessEvent() + "  " + ev[i][j].getAmount() + "  "+ ev[i][j].getAmountRemaining());
			}
			System.out.println();
		}
		
		for(int i = 1; i <= nunberOfProcesses; i++){
			
			System.out.println(snapShot[i].getProcessID() + " " + snapShot[i].getSnapShotTime());
		}
		
		//Check the timestamp with respect to Ev , for each of the process do the following 
		//1.Fetch the local snapshots of the processes
		//2.Make the messages after the snapShotTimestamp as red messages ( flag 1)
		//3.Fetch the white message (Flag 0) sent on the channel from the respective proess
		//4.Fetch the white messages (Flag 0 )received on the channel to the respective process
		//5.Subtract 3-4
		
		System.out.println("Setting messages red based on snapshot time given");
		//Setting Red messages in ev
		for(int i=1;i<=nunberOfProcesses;i++) {
			if(snapShot[i].getProcessID()==i) {
				for(int j=1;j <= numberOfEvents[i]; j++) {
					if(ev[i][j].getTime() >= snapShot[i].getSnapShotTime()) {
						ev[i][j].set(ev[i][j].channelID(), ev[i][j].getSendOrReceive(),1, ev[i][j].getTime(), ev[i][j].getFromProcess(), ev[i][j].getFromProcessEvent(), ev[i][j].getToProcess(), ev[i][j].getToProcessEvent(), ev[i][j].getAmount(), ev[i][j].getAmountRemaining());
					}
				}
			}
		}
		
		for(int i=1;i<=nunberOfProcesses;i++) {
			for(int j=1;j <= numberOfEvents[i]; j++) {
				System.out.println(ev[i][j].channelID()+ "  " + ev[i][j].getSendOrReceive() + "  " + ev[i][j].getTypeMessage() + "  " + ev[i][j].getTime() + "  " + ev[i][j].getFromProcess() + "  " + ev[i][j].getFromProcessEvent() + "  " + ev[i][j].getToProcess() + "  " + ev[i][j].getToProcessEvent() + "  " + ev[i][j].getAmount() + "  "+ ev[i][j].getAmountRemaining());
			}
			System.out.println();
		}
		
		
		
		for(int i=1;i<=nunberOfProcesses;i++) {
			int localSnapshotProcessAmount=0;
			if(snapShot[i].getProcessID()==i) {
				for(int j=1;j <= numberOfEvents[i]; j++) {
					if((ev[i][j].getTime() <= snapShot[i].getSnapShotTime()) &&  (ev[i][j].getTypeMessage()==0)) {
						localSnapshotProcessAmount = ev[i][j].getAmountRemaining();
					}
				}
			}
			localSnapShot[i]=localSnapshotProcessAmount;
		}
		
		System.out.println("Printing local snapshots for every process:");
		for(int i=1;i<=nunberOfProcesses;i++) {
			System.out.println(i + " " + localSnapShot[i]);
		}
		
		System.out.println("Calculating the total amount of white messages sent from process and the totl mount of received from white messages for each process");
		
		for(int i=1;i<=nunberOfProcesses;i++) {
			globalSnapShots[i] = new Global();
			int whiteMessagesSent=0,whiteMessagesReceived=0;
			for(int j=1;j <= numberOfEvents[i]; j++) {
				if(ev[i][j].getSendOrReceive()==0 && ev[i][j].getTypeMessage()==0) {
					whiteMessagesSent = whiteMessagesSent+ev[i][j].getAmount();
				}
				if(ev[i][j].getSendOrReceive()==1 && ev[i][j].getTypeMessage()==0) {
					whiteMessagesReceived = whiteMessagesReceived + ev[i][j].getAmount();
				}				
			}
			//global snapshot capture
			globalSnapShots[i].set(i, localSnapShot[i], whiteMessagesSent, whiteMessagesReceived, whiteMessagesSent-whiteMessagesReceived);
		}
		
		System.out.println("Printing out global snapshots:");
		for(int i=1;i<=nunberOfProcesses;i++) {			
				System.out.println(globalSnapShots[i].getProcessID()+ "  " + globalSnapShots[i].getProcessIDLocalSnapShot()+ "  "+ globalSnapShots[i].getWhiteMessagesSent()+ "  "+ globalSnapShots[i].getWhiteMessagesReceived()+ "  " + globalSnapShots[i].getSubWhiteSentAndReceived());
			}
		
		
		System.out.println("Printing out send channel white massages:");
		
		for(int i=1;i<=nunberOfProcesses;i++) {
			sendChannel[i] = new Channel[100];
			for(int j=1;j<=numberOfEvents[i];j++) {
				sendChannel[i][j] = new Channel();
				if(ev[i][j].getSendOrReceive()==0 && ev[i][j].getTypeMessage()==0) {
					int sendOrReceive=ev[i][j].getSendOrReceive();
					int whiteOrRed=ev[i][j].getTypeMessage();
					int fromProcess = ev[i][j].getFromProcess();
					int toProcess = ev[i][j].getToProcess();
					int amount = ev[i][j].getAmount();
					sendChannel[i][j].set(sendOrReceive, whiteOrRed, fromProcess, toProcess, amount);
				}
				
			}			
			
		}
		
		System.out.println("Printing sendChannel");
		for(int i=1;i<=nunberOfProcesses;i++) {
			System.out.println("Process :" + i);
			for(int j=1;j<=numberOfEvents[i];j++) {
				System.out.println(sendChannel[i][j].getSendOrReceive()+ " " + sendChannel[i][j].getWhiteOrRed() + " " + sendChannel[i][j].getFromProcess()+ " "+ sendChannel[i][j].getToProcess()+" "+sendChannel[i][j].getAmount());
			}
			System.out.println();
		}
		
		
		System.out.println("Printing out receive channel white massages:");
		
		for(int i=1;i<=nunberOfProcesses;i++) {
			receiveChannel[i] = new Channel[100];
			for(int j=1;j<=numberOfEvents[i];j++) {
				receiveChannel[i][j] = new Channel();
				if(ev[i][j].getSendOrReceive()==1 && ev[i][j].getTypeMessage()==0) {
					int sendOrReceive=ev[i][j].getSendOrReceive();
					int whiteOrRed=ev[i][j].getTypeMessage();
					int fromProcess = ev[i][j].getFromProcess();
					int toProcess = ev[i][j].getToProcess();
					int amount = ev[i][j].getAmount();
					receiveChannel[i][j].set(sendOrReceive, whiteOrRed, fromProcess, toProcess, amount);
				}
				
			}			
			
		}		
		System.out.println("Printing receiveChannel");
		for(int i=1;i<=nunberOfProcesses;i++) {
			System.out.println("Process :" + i);
			for(int j=1;j<=numberOfEvents[i];j++) {
				System.out.println(receiveChannel[i][j].getSendOrReceive()+ " " + receiveChannel[i][j].getWhiteOrRed() + " " + receiveChannel[i][j].getFromProcess()+ " "+ receiveChannel[i][j].getToProcess()+" "+receiveChannel[i][j].getAmount());
			}
			System.out.println();
		}
		
		System.out.println("For every send amount in sendChannel, we remove the amount if present in the receive channel:");
		for(int i=1;i<=nunberOfProcesses;i++) {
			for(int j=1;j<=numberOfEvents[i];j++) {
				int from = sendChannel[i][j].getFromProcess(); int to = sendChannel[i][j].getToProcess();int amount = sendChannel[i][j].getAmount();
				
				//Checking these values in receive channel;
				for(int x=1;x<=nunberOfProcesses;x++) {
					for(int y=1;y<=numberOfEvents[x];y++) {
						if((from == receiveChannel[x][y].getFromProcess()) && (to == receiveChannel[x][y].getToProcess()) && (amount == receiveChannel[x][y].getAmount())) {
							 receiveChannel[x][y].set(1, 0, receiveChannel[x][y].getFromProcess(), receiveChannel[x][y].getToProcess(), 0);
							 sendChannel[i][j].set(0, 0, sendChannel[i][j].getFromProcess(), sendChannel[i][j].getToProcess(), 0);
						}
						
					}
				}
				
			}
		}
		
		System.out.println("Printing sendChannel");
		for(int i=1;i<=nunberOfProcesses;i++) {
			System.out.println("Process :" + i);
			for(int j=1;j<=numberOfEvents[i];j++) {
				System.out.println(sendChannel[i][j].getSendOrReceive()+ " " + sendChannel[i][j].getWhiteOrRed() + " " + sendChannel[i][j].getFromProcess()+ " "+ sendChannel[i][j].getToProcess()+" "+sendChannel[i][j].getAmount());
			}
			System.out.println();
		}
		
		System.out.println("Printing receiveChannel");
		for(int i=1;i<=nunberOfProcesses;i++) {
			System.out.println("Process :" + i);
			for(int j=1;j<=numberOfEvents[i];j++) {
				System.out.println(receiveChannel[i][j].getSendOrReceive()+ " " + receiveChannel[i][j].getWhiteOrRed() + " " + receiveChannel[i][j].getFromProcess()+ " "+ receiveChannel[i][j].getToProcess()+" "+receiveChannel[i][j].getAmount());
			}
			System.out.println();
		}
		//Sum all the amount column in the sending channel.
		
		for(int i=1;i<=nunberOfProcesses;i++) {
			for(int j=1;j<=numberOfEvents[i];j++) {
				sumAmount=sumAmount+sendChannel[i][j].getAmount();
			}

		}
		System.out.println("White messages amount at snapshot time " + sumAmount);
				
		for(int i=1;i<=nunberOfProcesses;i++) {
			sumAmount = sumAmount + localSnapShot[i];
		}
		System.out.println("Initial amount :");
		for(int i=1;i<=nunberOfProcesses;i++) {
			System.out.println(i + " " + localSnapShot[i] + "  ");
		}
		
		System.out.println("Total snapshot: Sum of all amounts of white messages at snapshot time + sumAmount: " + sumAmount);
	}
}

public class LaiYang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Process pr = new Process();
		pr.calc();
	}

}
