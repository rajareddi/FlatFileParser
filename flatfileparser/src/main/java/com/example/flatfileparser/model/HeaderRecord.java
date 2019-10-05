package com.example.flatfileparser.model;

import org.beanio.annotation.Group;
import org.beanio.annotation.Record;

@Group(minOccurs = 0, maxOccurs = -1)
public class HeaderRecord {

	@Record(minOccurs = 1, maxOccurs = 1)
	private TX56 tx56;
	@Record(minOccurs = 1, maxOccurs = 1)
	private TX67 tx67;

	@Override
	public String toString() {
		return String.valueOf(getTx56()) + String.valueOf(getTx67());
	}

	public TX56 getTx56() {
		return tx56;
	}

	public void setTx56(TX56 tx56) {
		this.tx56 = tx56;
	}

	public TX67 getTx67() {
		return tx67;
	}

	public void setTx67(TX67 tx67) {
		this.tx67 = tx67;
	}
}