/*
 * Copyright (c) 2014-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.DEFAULT_PROPERTY_VALUE_TEXT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.VALIDATE_MEDIATOR_ICON_PATH;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.ValidateMediatorSerializer;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSNodeImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGroupingShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SingleCompartmentComplexFiguredAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.CustomToolTip;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EsbTextSelectionEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.ValidateMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.ValidateMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.GraphicalValidatorUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.MediatorValidationUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.ValidateMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * @generated NOT
 */
public class ValidateMediatorEditPart extends SingleCompartmentComplexFiguredAbstractMediator {

    public IFigure onFailOutputConnector;

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3623;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    public ValidateMediatorEditPart(View view) {
        super(view);
    }

    /**
     * @generated NOT
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ValidateMediatorItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ValidateMediatorCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // For handle Double click Event.
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {

        ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                View childView = (View) child.getModel();
                switch (EsbVisualIDRegistry.getVisualID(childView)) {
                case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
                case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
                case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
                    return new BorderItemSelectionEditPolicy();
                }
                if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
                    if (child instanceof ITextAwareEditPart) {
                        return new EsbTextSelectionEditPolicy();
                    }
                }
                return super.createChildEditPolicy(child);
            }
        };
        return lep;
    }

    /**
     * @generated NOT
     */
    protected IFigure createNodeShape() {
        return primaryShape = new ValidateMediatorFigure(new Color(null, 26, 188, 156),
                new Color(null, 255, 255, 255)) {
            public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
                super.setBounds(rect);
                if ((!connected) && (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0)) {
                    connectToMostSuitableElement();
                    reAllocate(rect);
                    connected = true;
                }
            };
        };
    }

    /**
     * @generated
     */
    public ValidateMediatorFigure getPrimaryShape() {
        return (ValidateMediatorFigure) primaryShape;
    }

    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ValidateMediatorInputConnectorEditPart) {
            IFigure borderItemFigure = ((ValidateMediatorInputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.WEST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        if (childEditPart instanceof ValidateMediatorOutputConnectorEditPart) {
            IFigure borderItemFigure = ((ValidateMediatorOutputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.EAST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        if (childEditPart instanceof ValidateMediatorOnFailOutputConnectorEditPart) {
            onFailOutputConnector = ((ValidateMediatorOnFailOutputConnectorEditPart) childEditPart).getFigure();
            onFailOutputConnector.setEnabled(false);
        }
        return false;
    }

    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof IBorderItemEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        return getContentPane();
    }

    /**
     * @generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
        return result;
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated NOT
     */
    protected NodeFigure createMainFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new StackLayout());
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        addLayoutListner(figure);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * 
     * @param nodeShape instance of generated figure class
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated
     */
    public class ValidateMediatorFigure extends EsbGroupingShape {

        /**
         * @generated
         */
        private WrappingLabel fFigureValidateMediatorPropertyValue;

        /**
         * @generated NOT
         */
        public ValidateMediatorFigure(Color bgColor, Color boderColor) {
            super(bgColor, boderColor);
            ToolbarLayout layoutThis = new ToolbarLayout();
            layoutThis.setStretchMinorAxis(true);
            layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

            layoutThis.setSpacing(0);
            layoutThis.setVertical(false);

            this.setLayoutManager(layoutThis);

            this.setBackgroundColor(THIS_BACK);
            this.setPreferredSize(new Dimension(getMapMode().DPtoLP(170), getMapMode().DPtoLP(100)));
            this.setOutline(false);
            this.setBackgroundColor(THIS_BACK);
            createContents();
        }

        public void add(IFigure figure, Object constraint, int index) {
            if (figure instanceof DefaultSizeNodeFigure) {
                GridData layoutData = new GridData();
                layoutData.grabExcessHorizontalSpace = true;
                layoutData.grabExcessVerticalSpace = true;
                layoutData.horizontalAlignment = GridData.FILL;
                layoutData.verticalAlignment = GridData.FILL;
                super.add(figure, layoutData, index);
            } else if (figure instanceof RoundedRectangle) {
                GridData layoutData = new GridData();
                layoutData.grabExcessHorizontalSpace = true;
                layoutData.grabExcessVerticalSpace = true;
                layoutData.horizontalAlignment = GridData.FILL;
                layoutData.verticalAlignment = GridData.FILL;
                super.add(figure, layoutData, index);
            }

            else {
                super.add(figure, constraint, index);
            }
        }

        /**
         * @generated NOT
         */
        private void createContents() {

            fFigureValidateMediatorPropertyValue = new WrappingLabel();
            fFigureValidateMediatorPropertyValue.setText(DEFAULT_PROPERTY_VALUE_TEXT);
            fFigureValidateMediatorPropertyValue.setAlignment(SWT.CENTER);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureValidateMediatorPropertyValue() {
            return fFigureValidateMediatorPropertyValue;
        }

        public String getIconPath() {
            return VALIDATE_MEDIATOR_ICON_PATH;
        }

        public String getNodeName() {
            return Messages.ValidateMediatorEditPart_NodeName;
        }

        public IFigure getToolTip() {
            if (StringUtils.isEmpty(toolTipMessage)) {
                toolTipMessage = Messages.ValidateMediatorEditPart_ToolTipMessage;
            }
            return new CustomToolTip().getCustomToolTipShape(toolTipMessage);
        }

    }

    @Override
    public void notifyChanged(Notification notification) {
        // this.getModel() will get EMF data model of the validate mediator data model
        if (this.getModel() instanceof CSSNodeImpl) {
            // The following part will check for validation issues with the current data in the model
            CSSNodeImpl model = (CSSNodeImpl) this.getModel();
            if (model.getElement() instanceof ValidateMediatorImpl) {
                ValidateMediatorImpl validateMediatorDataModel = (ValidateMediatorImpl) model.getElement();
                try {
                    org.apache.synapse.mediators.builtin.ValidateMediator validateMediator = ValidateMediatorTransformer
                            .createValidateMediator((EsbNode) validateMediatorDataModel, new TransformationInfo());

                    ValidateMediatorSerializer validateMediatorSerializer = new ValidateMediatorSerializer();
                    OMElement omElement = validateMediatorSerializer.serializeSpecificMediator(validateMediator);

                    if (StringUtils
                            .isEmpty(MediatorValidationUtil.validateMediatorsFromOEMElement(omElement, "validate"))) {
                        GraphicalValidatorUtil.removeValidationMark(this);
                    } else {
                        GraphicalValidatorUtil.addValidationMark(this);
                    }
                } catch (JaxenException | TransformerException | SynapseException e) {
                    GraphicalValidatorUtil.addValidationMark(this);
                }
            }
        }
        super.notifyChanged(notification);
    }
    
    /**
     * @generated NOT
     */
    static final Color THIS_BACK = new Color(null, 255, 255, 255);

}
