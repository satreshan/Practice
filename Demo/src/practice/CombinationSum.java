package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        dfs(0, 0, new ArrayList<>(), candidates, target, res);
        return res;
    }

    void dfs(int i, int total, List<Integer> currComb, int[] candidates, int target, List<List<Integer>> res){
        if(total == target){
            List<Integer> currComdCopy = new ArrayList<>();
            currComdCopy.addAll(currComb);
            res.add(currComdCopy);
            return;
        }
        if(i >= candidates.length || total > target)
            return;

        //find combination including candidates[i]
        total += candidates[i];
        currComb.add(candidates[i]);
        dfs(i, total, currComb, candidates, target, res);

        //find combination excluding candidates[i]
        currComb.remove(Integer.valueOf(candidates[i]));
        dfs(i+1, total - candidates[i], currComb, candidates, target, res);
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(candidates, 7));
    }
}
