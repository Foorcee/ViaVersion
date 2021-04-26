/*
 * This file is part of ViaVersion - https://github.com/ViaVersion/ViaVersion
 * Copyright (C) 2016-2021 ViaVersion and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.viaversion.viaversion.exception;

import com.viaversion.viaversion.api.ViaManager;
import io.netty.handler.codec.DecoderException;
import com.viaversion.viaversion.api.Via;

/**
 * Thrown during packet decoding when an incoming packet should be cancelled.
 * Specifically extends {@link DecoderException} to prevent netty from wrapping the exception.
 */
public class CancelDecoderException extends DecoderException implements CancelCodecException {
    public static final CancelDecoderException CACHED = new CancelDecoderException("This packet is supposed to be cancelled; If you have debug enabled, you can ignore these") {
        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    };

    public CancelDecoderException() {
        super();
    }

    public CancelDecoderException(String message, Throwable cause) {
        super(message, cause);
    }

    public CancelDecoderException(String message) {
        super(message);
    }

    public CancelDecoderException(Throwable cause) {
        super(cause);
    }

    /**
     * Returns a cached CancelDecoderException or a new instance when {@link ViaManager#isDebug()} is true.
     *
     * @param cause cause for being used when a new instance is creeated
     * @return a CancelDecoderException instance
     */
    public static CancelDecoderException generate(Throwable cause) {
        return Via.getManager().isDebug() ? new CancelDecoderException(cause) : CACHED;
    }
}
