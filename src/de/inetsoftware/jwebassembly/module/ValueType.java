/*
 * Copyright 2017 - 2018 Volker Berlin (i-net software)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.inetsoftware.jwebassembly.module;

import de.inetsoftware.jwebassembly.WasmException;

/**
 * @author Volker Berlin
 */
public enum ValueType {
    i32(-0x01),
    i64(-0x02),
    f32(-0x03),
    f64(-0x04),
    anyfunc(-0x10),
    anyref(-0x11),
    except_ref(-0x12),
    func(-0x20),
    empty(-0x40), // empty block_type
    ;

    private final int code;

    /**
     * Create instance of the enum
     * 
     * @param code
     *            the operation code in WebAssembly
     */
    private ValueType( int code ) {
        this.code = code;
    }

    /**
     * The operation code in WebAssembly.
     * 
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Get the WebAssembly value type from a Java signature.
     * 
     * @param javaSignature
     *            the signature
     * @return the value type
     */
    public static ValueType getValueType( String javaSignature ) {
        return new ValueTypeParser( javaSignature ).next();
    }

}
