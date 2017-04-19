package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate {
	private XorGate xorGate;
	private AndGate andGate;

	public HalfGate() {
		super(2, 3);

		name = "HALF";

		xorGate = new XorGate();
		andGate = new AndGate();
		
	}

	@Override
	public boolean doRead(int index) {
		if(index==0){			
			return xorGate.read();
			}

		else if(index==1){
			
			return andGate.read();
			}
		else {
			throw new IndexOutOfBoundsException();
			}
		}
		 

	@Override
	protected void doConnect(Emitter emitter, int index) {
		xorGate.connect(emitter, index);
		andGate.connect(emitter, index);
	}
}
