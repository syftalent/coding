	//***************deep iterator***************
	public static class NestedCollection implements Iterable<Object>{
		List<Object> objs;
		
		NestedCollection(List<Object> list){
			objs = list;
		}
		
		@Override
		public Iterator<Object> iterator() {
			return new NestedIterator(objs);
		}
		
		private class NestedIterator implements Iterator<Object>{
			
			private int index;
			private List<Object> objs;
			private Iterator<Object> curIterator;
			
			NestedIterator(List<Object> objs){
				index = 0;
				this.objs = objs;
			}
			
			@Override
			public boolean hasNext() {
				if(index == objs.size())	return false;
				Object obj = objs.get(index);
				if(obj instanceof NestedCollection){
					if(curIterator != null){
						if(curIterator.hasNext()){
							return true;
						}else{
							curIterator = null;
							index++;
							return this.hasNext();
						}
					}else{
						curIterator = ((NestedCollection)obj).iterator();
						return this.hasNext();
					}
				}else{
					return true;
				}
			}

			@Override
			public Object next() {
				if(this.hasNext()){
					Object obj = objs.get(index);
					if(obj instanceof NestedCollection){
						return curIterator.next();
					}else{
						index++;
						return obj;
					}
				}else{
					throw new RuntimeException("No next element");
				}
			}
			
		}
	}