
package test;

import java.util.ArrayList;
import il.ac.wis.cs.common.lsc.element.ArgumentType;
import il.ac.wis.cs.common.lsc.element.Binding;
import il.ac.wis.cs.common.lsc.element.ExecutionKind;
import il.ac.wis.cs.common.lsc.element.LSCCollaboration;
import il.ac.wis.cs.common.lsc.element.LSCCombinedFragment;
import il.ac.wis.cs.common.lsc.element.LSCConstraintExpr;
import il.ac.wis.cs.common.lsc.element.LSCInteraction;
import il.ac.wis.cs.common.lsc.element.LSCInteractionOperand;
import il.ac.wis.cs.common.lsc.element.LSCLifeline;
import il.ac.wis.cs.common.lsc.element.LSCLogicalOperator;
import il.ac.wis.cs.common.lsc.element.LSCOperator;
import il.ac.wis.cs.common.lsc.element.LifelineType;
import il.ac.wis.cs.common.lsc.element.MessageArgType;
import il.ac.wis.cs.common.lsc.element.MessageFlowType;
import il.ac.wis.cs.common.lsc.element.MessageParameter;
import il.ac.wis.cs.common.lsc.element.Temperature;
import il.ac.wis.cs.common.lsc.test.element.LSCElementTestNoJunit;


/**
 * This file was automatically generated using PlayGo Model import.
 * 
 */
public class CreateCarHandler
    extends LSCElementTestNoJunit
{

    private LSCCollaboration collaboration;

    public void testCreateCarHandler() {
        setUp();
        model.setName("CarHandler");
        collaboration = model.createLSCCollaboration();

        createHandleArrival();
        createEntranceMove();
        createExitMove();
        createHandleDeparture();
        createHandleDeparture();
        createHandleDeparture();
        createHandleDeparture();
         
        save(model); // saves the model in the current package
    }

    public void createHandleArrival() {
        LSCInteraction lsc = (collaboration.createLSC("HandleArrival"));
         
        LSCLifeline carLifeline = lsc.createLSCLifeline("car", "Car", LifelineType.SYSTEM, Binding.DYNAMIC);
        carLifeline.createProperty("direction", ArgumentType.String.toString());
        carLifeline.createProperty("terminal", ArgumentType.Int.toString(), "0");
        carLifeline.createProperty("platform", ArgumentType.Int.toString(), "0");
        LSCLifeline terminalLifeline = lsc.createLSCLifeline("terminal", "Terminal", LifelineType.SYSTEM, Binding.DYNAMIC);
        terminalLifeline.createProperty("ID", ArgumentType.Int.toString(), "0");
        LSCLifeline platformManagerLifeline = lsc.createLSCLifeline("platformManager", "PlatformManager", LifelineType.SYSTEM, Binding.DYNAMIC);
        platformManagerLifeline.setBindingExpression("PropertyProperty,platformManager,ID,==,terminal,ID,&&;");
        platformManagerLifeline.createProperty("ID", ArgumentType.Int.toString(), "0");
        LSCLifeline entranceLifeline = lsc.createLSCLifeline("entrance", "Entrance", LifelineType.SYSTEM, Binding.DYNAMIC);
        entranceLifeline.setBindingExpression("PropertyProperty,entrance,terminalId,==,terminal,ID,&&;PropertyProperty,entrance,direction,==,car,direction,&&;");
        entranceLifeline.createProperty("terminalId", ArgumentType.Int.toString(), "0");
        entranceLifeline.createProperty("direction", ArgumentType.String.toString());
         
        ArrayList params;
        MessageParameter par;
        MessageArgType argType;
        params = new ArrayList<MessageParameter>();
        par=new MessageParameter("direction","String","null",MessageArgType.SYMBOLIC);
        params.add(par);
        il.ac.wis.cs.common.lsc.element.LSCMessage arriveReq = lsc.createLSCMessage(carLifeline, terminalLifeline, "arriveReq", params, "void", Temperature.Cold, ExecutionKind.MONITORED);
        arriveReq.setFlowType(MessageFlowType.Regular);
        arriveReq.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage allocatePlatform = lsc.createLSCMessage(terminalLifeline, platformManagerLifeline, "allocatePlatform", Temperature.Hot, ExecutionKind.EXECUTE);
        allocatePlatform.setFlowType(MessageFlowType.Regular);
        allocatePlatform.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        params = new ArrayList<MessageParameter>();
        par=new MessageParameter("number","int","null",MessageArgType.SYMBOLIC);
        params.add(par);
        il.ac.wis.cs.common.lsc.element.LSCMessage platformAllocated = lsc.createLSCMessage(platformManagerLifeline, terminalLifeline, "platformAllocated", params, "void", Temperature.Cold, ExecutionKind.MONITORED);
        platformAllocated.setFlowType(MessageFlowType.Regular);
        platformAllocated.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        params = new ArrayList<MessageParameter>();
        par=new MessageParameter("platform","int","number",MessageArgType.OPAQUE_EXPRESSION);
        params.add(par);
        il.ac.wis.cs.common.lsc.element.LSCMessage moveTo = lsc.createLSCMessage(terminalLifeline, entranceLifeline, "moveTo", params, "void", Temperature.Hot, ExecutionKind.EXECUTE);
        moveTo.setFlowType(MessageFlowType.Regular);
        moveTo.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
        moveTo.setTimeTagName("");
         
        il.ac.wis.cs.common.lsc.element.LSCMessage moveCompleted = lsc.createLSCMessage(entranceLifeline, terminalLifeline, "moveCompleted", Temperature.Cold, ExecutionKind.MONITORED);
        moveCompleted.setFlowType(MessageFlowType.Regular);
        moveCompleted.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        params = new ArrayList<MessageParameter>();
        par=new MessageParameter("arg0","int","number",MessageArgType.OPAQUE_EXPRESSION);
        params.add(par);
        il.ac.wis.cs.common.lsc.element.LSCMessage setPlatform = lsc.createLSCMessage(terminalLifeline, carLifeline, "setPlatform", params, "void", Temperature.Hot, ExecutionKind.EXECUTE);
        setPlatform.setFlowType(MessageFlowType.Regular);
        setPlatform.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage arriveAck = lsc.createLSCMessage(terminalLifeline, carLifeline, "arriveAck", Temperature.Hot, ExecutionKind.EXECUTE);
        arriveAck.setFlowType(MessageFlowType.Regular);
        arriveAck.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
    }

    public void createEntranceMove() {
        LSCInteraction lsc = (collaboration.createLSC("EntranceMove"));
         
        LSCLifeline terminalLifeline = lsc.createLSCLifeline("terminal", "Terminal", LifelineType.SYSTEM, Binding.DYNAMIC);
        terminalLifeline.createProperty("ID", ArgumentType.Int.toString(), "0");
        LSCLifeline entranceLifeline = lsc.createLSCLifeline("entrance", "Entrance", LifelineType.SYSTEM, Binding.DYNAMIC);
        entranceLifeline.setBindingExpression("");
        entranceLifeline.createProperty("terminalId", ArgumentType.Int.toString(), "0");
        entranceLifeline.createProperty("direction", ArgumentType.String.toString());
         
        ArrayList params;
        MessageParameter par;
        MessageArgType argType;
        params = new ArrayList<MessageParameter>();
        par=new MessageParameter("platform","int","null",MessageArgType.SYMBOLIC);
        params.add(par);
        il.ac.wis.cs.common.lsc.element.LSCMessage moveTo = lsc.createLSCMessage(terminalLifeline, entranceLifeline, "moveTo", params, "void", Temperature.Cold, ExecutionKind.MONITORED);
        moveTo.setFlowType(MessageFlowType.Regular);
        moveTo.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage moveCompleted = lsc.createLSCMessage(entranceLifeline, terminalLifeline, "moveCompleted", Temperature.Hot, ExecutionKind.EXECUTE);
        moveCompleted.setFlowType(MessageFlowType.Regular);
        moveCompleted.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
    }

    public void createExitMove() {
        LSCInteraction lsc = (collaboration.createLSC("ExitMove"));
         
        LSCLifeline terminalLifeline = lsc.createLSCLifeline("terminal", "Terminal", LifelineType.SYSTEM, Binding.DYNAMIC);
        terminalLifeline.createProperty("ID", ArgumentType.Int.toString(), "0");
        LSCLifeline exitLifeline = lsc.createLSCLifeline("exit", "Exit", LifelineType.SYSTEM, Binding.DYNAMIC);
        exitLifeline.createProperty("ID", ArgumentType.Int.toString(), "0");
        exitLifeline.createProperty("direction", ArgumentType.String.toString());
         
        ArrayList params;
        MessageParameter par;
        MessageArgType argType;
        params = new ArrayList<MessageParameter>();
        par=new MessageParameter("platform","int","null",MessageArgType.SYMBOLIC);
        params.add(par);
        il.ac.wis.cs.common.lsc.element.LSCMessage moveTo = lsc.createLSCMessage(terminalLifeline, exitLifeline, "moveTo", params, "void", Temperature.Cold, ExecutionKind.MONITORED);
        moveTo.setFlowType(MessageFlowType.Regular);
        moveTo.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage moveCompleted = lsc.createLSCMessage(exitLifeline, terminalLifeline, "moveCompleted", Temperature.Hot, ExecutionKind.EXECUTE);
        moveCompleted.setFlowType(MessageFlowType.Regular);
        moveCompleted.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
    }

    public void createHandleDeparture() {
        LSCInteraction lsc = (collaboration.createLSC("HandleDeparture"));
         
    }

    public void createHandleDeparture() {
        LSCInteraction lsc = (collaboration.createLSC("HandleDeparture"));
         
    }

    public void createHandleDeparture() {
        LSCInteraction lsc = (collaboration.createLSC("HandleDeparture"));
         
    }

    public void createHandleDeparture() {
        LSCInteraction lsc = (collaboration.createLSC("HandleDeparture"));
         
        LSCLifeline carLifeline = lsc.createLSCLifeline("car", "Car", LifelineType.SYSTEM, Binding.DYNAMIC);
        carLifeline.createProperty("direction", ArgumentType.String.toString());
        carLifeline.createProperty("terminal", ArgumentType.Int.toString(), "0");
        carLifeline.createProperty("platform", ArgumentType.Int.toString(), "0");
        LSCLifeline terminalLifeline = lsc.createLSCLifeline("terminal", "Terminal", LifelineType.SYSTEM, Binding.DYNAMIC);
        terminalLifeline.setBindingExpression("");
        terminalLifeline.createProperty("ID", ArgumentType.Int.toString(), "0");
        LSCLifeline exitsManagerLifeline = lsc.createLSCLifeline("exitsManager", "ExitsManager", LifelineType.SYSTEM, Binding.DYNAMIC);
        exitsManagerLifeline.setBindingExpression("PropertyProperty,existsManager,ID,==,terminal,ID,&&;");
        exitsManagerLifeline.createProperty("ID", ArgumentType.Int.toString(), "0");
        exitsManagerLifeline.createProperty("platformHandling", ArgumentType.Int.toString(), "0");
        LSCLifeline exitLifeline = lsc.createLSCLifeline("exit", "Exit", LifelineType.SYSTEM, Binding.DYNAMIC);
        exitLifeline.setBindingExpression("PropertyProperty,exit,ID,==,terminal,ID,&&;PropertyProperty,exit,direction,==,car,direction,&&;");
        exitLifeline.createProperty("ID", ArgumentType.Int.toString(), "0");
        exitLifeline.createProperty("direction", ArgumentType.String.toString());
         
        ArrayList coveredLifelines;
        coveredLifelines = new ArrayList<LSCLifeline>();
        coveredLifelines.add(carLifeline);
        coveredLifelines.add(terminalLifeline);
        coveredLifelines.add(exitsManagerLifeline);
        coveredLifelines.add(exitLifeline);
        LSCCombinedFragment Alternatives0 = lsc.createLSCAltFragment("Alternatives0", coveredLifelines, 0);
         
        LSCInteractionOperand Alternatives0Oper1 = Alternatives0 .createOpaqueOperand("car.platform == 1", "car.platform == 1");
        ArrayList constrExpressions;
        LSCConstraintExpr expr;
        constrExpressions = new ArrayList<LSCConstraintExpr>();
        expr = 
        new LSCConstraintExpr(carLifeline, carLifeline.getProperty("platform"), "1", LSCOperator.Equal, LSCLogicalOperator.And, false);
        constrExpressions.add(expr);
        Alternatives0Oper1.setConstrExpressions(constrExpressions);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage allocateExit1 = lsc.createLSCMessage(terminalLifeline, exitsManagerLifeline, "allocateExit1", Temperature.Hot, ExecutionKind.EXECUTE, Alternatives0Oper1);
        allocateExit1 .setFlowType(MessageFlowType.Regular);
        allocateExit1.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        LSCInteractionOperand Alternatives0Oper2 = Alternatives0 .createOpaqueOperand("car.platform == 2", "car.platform == 2");
        constrExpressions = new ArrayList<LSCConstraintExpr>();
        expr = 
        new LSCConstraintExpr(carLifeline, carLifeline.getProperty("platform"), "2", LSCOperator.Equal, LSCLogicalOperator.And, false);
        constrExpressions.add(expr);
        Alternatives0Oper2.setConstrExpressions(constrExpressions);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage allocateExit2 = lsc.createLSCMessage(terminalLifeline, exitsManagerLifeline, "allocateExit2", Temperature.Hot, ExecutionKind.EXECUTE, Alternatives0Oper2);
        allocateExit2 .setFlowType(MessageFlowType.Regular);
        allocateExit2.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        LSCInteractionOperand Alternatives0Oper3 = Alternatives0 .createOpaqueOperand("car.platform == 3", "car.platform == 3");
        constrExpressions = new ArrayList<LSCConstraintExpr>();
        expr = 
        new LSCConstraintExpr(carLifeline, carLifeline.getProperty("platform"), "3", LSCOperator.Equal, LSCLogicalOperator.And, false);
        constrExpressions.add(expr);
        Alternatives0Oper3.setConstrExpressions(constrExpressions);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage allocateExit3 = lsc.createLSCMessage(terminalLifeline, exitsManagerLifeline, "allocateExit3", Temperature.Hot, ExecutionKind.EXECUTE, Alternatives0Oper3);
        allocateExit3 .setFlowType(MessageFlowType.Regular);
        allocateExit3.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        LSCInteractionOperand Alternatives0Oper4 = Alternatives0 .createOpaqueOperand("car.platform == 4", "car.platform == 4");
        constrExpressions = new ArrayList<LSCConstraintExpr>();
        expr = 
        new LSCConstraintExpr(carLifeline, carLifeline.getProperty("platform"), "4", LSCOperator.Equal, LSCLogicalOperator.And, false);
        constrExpressions.add(expr);
        Alternatives0Oper4.setConstrExpressions(constrExpressions);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage allocateExit4 = lsc.createLSCMessage(terminalLifeline, exitsManagerLifeline, "allocateExit4", Temperature.Hot, ExecutionKind.EXECUTE, Alternatives0Oper4);
        allocateExit4 .setFlowType(MessageFlowType.Regular);
        allocateExit4.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage departReq = lsc.createLSCMessage(carLifeline, terminalLifeline, "departReq", Temperature.Cold, ExecutionKind.MONITORED);
        departReq.setFlowType(MessageFlowType.Regular);
        departReq.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage blank = lsc.createLSCMessage(exitLifeline, exitLifeline, "blank", Temperature.Hot, ExecutionKind.EXECUTE);
        blank.setFlowType(MessageFlowType.Regular);
        blank.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        coveredLifelines = new ArrayList<LSCLifeline>();
        coveredLifelines.add(carLifeline);
        coveredLifelines.add(terminalLifeline);
        coveredLifelines.add(exitsManagerLifeline);
        coveredLifelines.add(exitLifeline);
        LSCCombinedFragment Alternatives1 = lsc.createLSCAltFragment("Alternatives1", coveredLifelines, 0);
         
        LSCInteractionOperand Alternatives1Oper1 = Alternatives1 .createOpaqueOperand("exitsManager.platformHandling == car.platform", "exitsManager.platformHandling == car.platform");
        constrExpressions = new ArrayList<LSCConstraintExpr>();
        expr = 
        new LSCConstraintExpr(exitsManagerLifeline, exitsManagerLifeline.getProperty("platformHandling"), carLifeline, carLifeline.getProperty("platform"), LSCOperator.Equal, LSCLogicalOperator.And);
        constrExpressions.add(expr);
        Alternatives1Oper1.setConstrExpressions(constrExpressions);
         
        ArrayList params;
        MessageParameter par;
        MessageArgType argType;
        params = new ArrayList<MessageParameter>();
        par=new MessageParameter("platform","int","car.getPlatform()",MessageArgType.OPAQUE_EXPRESSION);
        params.add(par);
        il.ac.wis.cs.common.lsc.element.LSCMessage moveTo = lsc.createLSCMessage(terminalLifeline, exitLifeline, "moveTo", params, "void", Temperature.Hot, ExecutionKind.EXECUTE, Alternatives1Oper1);
        moveTo.setFlowType(MessageFlowType.Regular);
        moveTo.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
        moveTo.setTimeTagName("");
         
        il.ac.wis.cs.common.lsc.element.LSCMessage moveCompleted = lsc.createLSCMessage(exitLifeline, terminalLifeline, "moveCompleted", Temperature.Cold, ExecutionKind.MONITORED, Alternatives1Oper1);
        moveCompleted.setFlowType(MessageFlowType.Regular);
        moveCompleted.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
         
        il.ac.wis.cs.common.lsc.element.LSCMessage departAck = lsc.createLSCMessage(terminalLifeline, carLifeline, "departAck", Temperature.Hot, ExecutionKind.EXECUTE, Alternatives1Oper1);
        departAck.setFlowType(MessageFlowType.Regular);
        departAck.setForbiddenLevel(il.ac.wis.cs.common.lsc.element.ForbiddenLevel.SPECIFIED_MESSAGE_ONLY);
        departAck.setTimeTagName("");
    }
    
	public static void main(String[] args){
		new CreateCarHandler().testCreateCarHandler();
		System.exit(0);
	}

}
