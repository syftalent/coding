public class Main {

	public static boolean twentyfour(List<Integer> nums, int target){
		if(nums.size() == 0)	return false;
		if(nums.size() == 1 && nums.get(0) == target)	return true;

		for(int i=0; i<nums.size()-1; i++){
			for(int j=i+1; j<nums.size(); j++){
				int num1 = nums.get(i);
				int num2 = nums.get(j);
				nums.remove(j);
				nums.remove(i);

				//+
				nums.add(num1 + num2);
				if(twentyfour(nums, target)){
					return true;
				}else{
					nums.remove(nums.size() - 1);
				}

				//-
				nums.add(num1 - num2);
				if(twentyfour(nums, target)){
					return true;
				}else{
					nums.remove(nums.size() - 1);
				}

				nums.add(num2 - num1);
				if(twentyfour(nums, target)){
					return true;
				}else{
					nums.remove(nums.size() - 1);
				}

				//*
				nums.add(num1 * num2);
				if(twentyfour(nums, target)){
					return true;
				}else{
					nums.remove(nums.size() - 1);
				}

				// /
				if(num2 != 0){
					nums.add(num1 / num2);
					if(twentyfour(nums, target)){
						return true;
					}else{
						nums.remove(nums.size() - 1);
					}
				}

				if(num1 != 0){
					nums.add(num2 / num1);
					if(twentyfour(nums, target)){
						return true;
					}else{
						nums.remove(nums.size() - 1);
					}
				}

				nums.add(i, num1);
				nums.add(j, num2);
			}
		}
		return false;
	}

	
	public static void main(String[] args){
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
		res.add(1);
		res.add(2);
		res.add(6);
		System.out.println(twentyfour(res, 24));
	}
}
