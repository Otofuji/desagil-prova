package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate {
	private XorGate xorLeft;
	private XorGate xorRight;
	private AndGate andUp;
	private AndGate andDown;
	private OrGate orGate;

	public FullGate() {
		super(3, 2);

		name = "FULL";

		xorLeft = new XorGate();
		xorRight = new XorGate();
		xorRight.connect(xorLeft, 0);
		andUp = new AndGate();
		andUp.connect(xorLeft, 0);
		andDown = new AndGate();
		orGate = new OrGate();
		orGate.connect(andUp, 0);
		orGate.connect(andDown, 1);
		
	}

	@Override
	public boolean doRead(int index) {
		if(index==0){			
			return xorRight.read();
			}

		else if(index==1){
			
			return orGate.read();
			}
		else {
			throw new IndexOutOfBoundsException();
			}
		}
	

	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		case 0:
			xorLeft.connect(emitter, 0);
			andDown.connect(emitter, 0);
			break;
		case 1:
			xorLeft.connect(emitter, 1);
			andDown.connect(emitter, 1);
			break;
		case 2:
			xorRight.connect(emitter, 1);
			andUp.connect(emitter, 1);
			break;
		}
	}
}
