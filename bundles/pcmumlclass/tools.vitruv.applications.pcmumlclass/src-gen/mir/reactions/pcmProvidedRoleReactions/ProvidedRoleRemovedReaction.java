package mir.reactions.pcmProvidedRoleReactions;

import mir.routines.pcmProvidedRoleReactions.RoutinesFacade;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.RemoveEReference;

@SuppressWarnings("all")
public class ProvidedRoleRemovedReaction extends AbstractReactionRealization {
  private RemoveEReference<InterfaceProvidingRequiringEntity, OperationProvidedRole> removeChange;
  
  private int currentlyMatchedChange;
  
  public ProvidedRoleRemovedReaction(final RoutinesFacade routinesFacade) {
    super(routinesFacade);
  }
  
  public void executeReaction(final EChange change) {
    if (!checkPrecondition(change)) {
    	return;
    }
    org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity affectedEObject = removeChange.getAffectedEObject();
    EReference affectedFeature = removeChange.getAffectedFeature();
    org.palladiosimulator.pcm.repository.OperationProvidedRole oldValue = removeChange.getOldValue();
    int index = removeChange.getIndex();
    				
    getLogger().trace("Passed change matching of Reaction " + this.getClass().getName());
    if (!checkUserDefinedPrecondition(removeChange, affectedEObject, affectedFeature, oldValue, index)) {
    	resetChanges();
    	return;
    }
    getLogger().trace("Passed complete precondition check of Reaction " + this.getClass().getName());
    				
    mir.reactions.pcmProvidedRoleReactions.ProvidedRoleRemovedReaction.ActionUserExecution userExecution = new mir.reactions.pcmProvidedRoleReactions.ProvidedRoleRemovedReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(removeChange, affectedEObject, affectedFeature, oldValue, index, this.getRoutinesFacade());
    
    resetChanges();
  }
  
  private void resetChanges() {
    removeChange = null;
    currentlyMatchedChange = 0;
  }
  
  private boolean matchRemoveChange(final EChange change) {
    if (change instanceof RemoveEReference<?, ?>) {
    	RemoveEReference<org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity, org.palladiosimulator.pcm.repository.OperationProvidedRole> _localTypedChange = (RemoveEReference<org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity, org.palladiosimulator.pcm.repository.OperationProvidedRole>) change;
    	if (!(_localTypedChange.getAffectedEObject() instanceof org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity)) {
    		return false;
    	}
    	if (!_localTypedChange.getAffectedFeature().getName().equals("providedRoles_InterfaceProvidingEntity")) {
    		return false;
    	}
    	if (!(_localTypedChange.getOldValue() instanceof org.palladiosimulator.pcm.repository.OperationProvidedRole)) {
    		return false;
    	}
    	this.removeChange = (RemoveEReference<org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity, org.palladiosimulator.pcm.repository.OperationProvidedRole>) change;
    	return true;
    }
    
    return false;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (currentlyMatchedChange == 0) {
    	if (!matchRemoveChange(change)) {
    		resetChanges();
    		return false;
    	} else {
    		currentlyMatchedChange++;
    	}
    }
    
    return true;
  }
  
  private boolean checkUserDefinedPrecondition(final RemoveEReference removeChange, final InterfaceProvidingRequiringEntity affectedEObject, final EReference affectedFeature, final OperationProvidedRole oldValue, final int index) {
    boolean _contains = affectedEObject.getProvidedRoles_InterfaceProvidingEntity().contains(oldValue);
    return (!_contains);
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final RemoveEReference removeChange, final InterfaceProvidingRequiringEntity affectedEObject, final EReference affectedFeature, final OperationProvidedRole oldValue, final int index, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.removeCorrespondingProvidedRealization(oldValue, affectedEObject);
    }
  }
}
