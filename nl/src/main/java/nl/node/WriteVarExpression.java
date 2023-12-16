package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import nl.node.Node;

@NodeField(name = "slot", type = int.class)
@NodeChild("target")
public abstract class WriteVarExpression extends Node {
    protected WriteVarExpression(TruffleLanguage<?> language) {
        super(language);
    }
    protected abstract int getSlot();
    @Specialization()
    protected Object write(VirtualFrame frame, Object value) {
        frame.getFrameDescriptor().setSlotKind(getSlot(), FrameSlotKind.Object);

        frame.setObject(getSlot(), value);
        return value;
    }

}
