/*
 * Copyright (C) 2016 Dmitriy Merkushov
 * Copyright (C) 2013 Brian P. Hinz
 * Copyright (C) 2002-2005 RealVNC Ltd.  All Rights Reserved.
 * Copyright (C) 2001 Markus G. Kuhn, University of Cambridge
 *
 * This is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this software; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,
 * USA.
 */
package ru.dmerkushov.vnc.client.ui.events;

import java.awt.event.KeyEvent;

import static ru.dmerkushov.vnc.client.VncCommon.logger;

/**
 * @author dmerkushov
 */
public class Keysyms11 extends Keysyms {

	public static int translateFxKeyEvent (javafx.scene.input.KeyEvent ev) {
		javafx.scene.input.KeyCode fxKeyCode = ev.getCode ();

		boolean controlDown = ev.isControlDown ();
		boolean shiftDown = ev.isShiftDown ();

		char keyChar = KeyEvent.CHAR_UNDEFINED;
		String keyCharStr = fxKeyCode.getChar();
		if (keyCharStr != null && keyCharStr.length () > 0) {
			keyChar = keyCharStr.charAt (0);
			logger.finest ("KeyCharStr " + keyCharStr);
		}
		if (!shiftDown) {
			keyChar = Character.toLowerCase (keyChar);
		}
		logger.finest ("keyChar " + keyChar);

		int awtKeyCode = fxKeyCode.getCode ();

		int location = KeyEvent.KEY_LOCATION_UNKNOWN;

		return Keysyms.translateAwtKeyEvent (controlDown, shiftDown, keyChar, location, awtKeyCode);
	}
}
