package problems.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Example 1:
 * 
 * Input: num = "123", target = 6 Output: ["1+2+3", "1*2*3"] Example 2:
 * 
 * Input: num = "232", target = 8 Output: ["2*3+2", "2+3*2"] Example 3:
 * 
 * Input: num = "105", target = 5 Output: ["1*0+5","10-5"] Example 4:
 * 
 * Input: num = "00", target = 0 Output: ["0+0", "0-0", "0*0"] Example 5:
 * 
 * Input: num = "3456237490", target = 9191 Output: []
 * 
 * @author Sushil
 *
 */
public class ExpressionAddOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, 0, 0, 0, "", num, target);
        return res;
    }
    
    private void dfs(List<String> res, int idx, long bufVal, long sum,
                     String path, String num, int target) {
        if (idx == num.length()) {
            if (sum + bufVal == target) {
                res.add(path);
            }
            return;
        } 
        
        for (int i = idx; i < num.length(); i++) {
            if (i != idx && num.charAt(idx) == '0') {
                break;
            }
            
            long cur = Long.parseLong(num.substring(idx, i + 1));
            if (idx == 0) {
                dfs(res, i + 1, cur, sum, path + cur, num, target);   
            } else {
                dfs(res, i + 1, cur, sum + bufVal, path + "+" + cur, num, target);
                dfs(res, i + 1, -cur, sum + bufVal, path + "-" + cur, num, target);
                dfs(res, i + 1, bufVal * cur, sum, path + "*" + cur, num, target);
            }
        }
    }
}
