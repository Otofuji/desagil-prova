package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate {
	private XorGate xorGate;
	private AndGate andGate;

	public HalfGate() {
		super(2, 1);

		name = "HALFADDER";

		xorGate = new XorGate();
		andGate = new AndGate();
		
	}

	@Override
	public boolean doRead(int index) {
		return xorGate.read();

	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		xorGate.connect(emitter, index);
		andGate.connect(emitter, index);
	}
}
