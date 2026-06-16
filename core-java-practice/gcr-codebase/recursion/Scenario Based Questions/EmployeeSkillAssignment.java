import java.util.ArrayList;
import java.util.List;

public class EmployeeSkillAssignment {
    public static void main(String[] args) {
        findTeams(new int[]{2, 3, 5, 7}, 10, 0, new ArrayList<>());
    }

    static void findTeams(int[] skills, int target, int index, List<Integer> team) {
        if (target == 0) {
            System.out.println(team);
            return;
        }
        if (index >= skills.length || target < 0) return;
        
        team.add(skills[index]);
        findTeams(skills, target - skills[index], index + 1, team);
        team.remove(team.size() - 1);
        
        findTeams(skills, target, index + 1, team);
    }
}
