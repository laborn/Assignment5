package iterator;

import java.util.List;

public class StockListIterator implements ListIterator {
	
	private List<String> stocks;
	private int currentPosition = 0;

	public StockListIterator(List<String> stocks) {
		
		this.stocks = stocks;
	}

	@Override
	public boolean isDone() {
		
		if (currentPosition + 1 > stocks.size()){
			return true;
		}
		return false;
	}

	@Override
	public void next() {
		
		currentPosition++;
	}

	@Override
	public String currentItem() {
		
		return stocks.get(currentPosition);
	}
}