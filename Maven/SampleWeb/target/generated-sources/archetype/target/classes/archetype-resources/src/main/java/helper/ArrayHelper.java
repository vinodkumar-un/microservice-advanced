#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.helper;

public class ArrayHelper {
	public int[] reverse(int[] input) throws Exception {
		int[] output = null;

		if (input == null || input.length <= 0) {
			throw new Exception("Input Array is empty");
		}

		output = new int[input.length];
		int j = 0;
		for (int i = input.length - 1; i >= 0; i--) {
			output[j++] = input[i];
		}
		return output;
	}
}
