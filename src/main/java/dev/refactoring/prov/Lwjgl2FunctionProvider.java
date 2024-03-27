package dev.refactoring.prov;

import org.lwjgl.opengl.GLContext;
import org.lwjgl.system.FunctionProvider;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/**
 * This class is only required in legacy versions which use LWJGL 2.
 *
 * @author DJ The Redstoner
 */
public class Lwjgl2FunctionProvider implements FunctionProvider {

    private final Method m_getFunctionAddress;

    public Lwjgl2FunctionProvider() {
        try {
            m_getFunctionAddress = GLContext.class.getDeclaredMethod("getFunctionAddress", String.class);
            m_getFunctionAddress.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long getFunctionAddress(CharSequence functionName) {
        try {
            return (long) m_getFunctionAddress.invoke(null, functionName.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long getFunctionAddress(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }
}