package designpattern.behavioral.ACstate;

/**
 * 状态切换
 */
public class StateTest {

    public static void main(String[] args) {

        SKTTeam sktTeam = new SKTTeam();
        TeamState state = new VocationState();
        sktTeam.setTeamState(state);
        sktTeam.startGame();


//        sktTeam.startGame();
//
//        sktTeam.nextState();
//
//
//        sktTeam.startGame();
//
//        sktTeam.nextState();
//        sktTeam.startGame();


        state = state.next();
        sktTeam.setTeamState(state);
        sktTeam.startGame();


        //状态需要维护自己的切换逻辑
        state = state.next();
        sktTeam.setTeamState(state);
        sktTeam.startGame();
    }
}
/**
 * 什么场景用到？
 * 策略模式和状态模式是一样的？
 * 状态模式核心需要具体状态类能在必要的时候切换状态
 * 流程框架与状态机
 */