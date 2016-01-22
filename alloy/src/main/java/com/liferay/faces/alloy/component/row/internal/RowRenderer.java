/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.alloy.component.row.internal;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import com.liferay.faces.alloy.component.row.Row;


/**
 * @author  Juan Gonzalez
 */
public class RowRenderer extends Renderer {

	// Private Constants
	private static final String ROW_FLUID = "row-fluid";
	private static final String ROW = "row";

	@Override
	public void encodeBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		Row row = (Row) uiComponent;

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.startElement("div", uiComponent);

		String id = uiComponent.getClientId(facesContext);
		responseWriter.writeAttribute("id", id, null);

		StringBuilder classNames = new StringBuilder();

		if (row.isFluid()) {
			classNames = classNames.append(ROW_FLUID);
		}
		else {
			classNames.append(ROW);
		}

		String cssClass = row.getCssClass();

		if ((cssClass != null) && (cssClass.length() > 0)) {
			classNames.append(" ");
			classNames.append(cssClass);
		}

		String styleClass = row.getStyleClass();

		if ((styleClass != null) && (styleClass.length() > 0)) {
			classNames.append(" ");
			classNames.append(styleClass);
		}

		responseWriter.writeAttribute("class", classNames.toString(), null);
	}

	@Override
	public void encodeEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.endElement("div");
	}
}
