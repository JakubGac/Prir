package Prir;

import java.util.List;

import Condition.Condition;
import Loading.DataLoading;

public class Main {

	public static void main(String []args) throws Exception {
		
		// code for testing data loading
		DataLoading data = new DataLoading();
		// reading functions
		//data.FunctionLoading();
		// reading area
		data.AreaLoading();
		// reading conditions
		data.ConditionLoading();
		List<Condition> conditions = data.getConditionsList();
		System.out.println(conditions.toString());
	}
}