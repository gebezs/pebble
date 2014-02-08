package com.mitchellbosecke.pebble.extension.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.mitchellbosecke.pebble.extension.Test;

public class EmptyTest implements Test {

	@Override
	public List<String> getArgumentNames() {
		return null;
	}

	@Override
	public boolean apply(Object input, Map<String, Object> args) {
		boolean isEmpty = input == null;

		if (!isEmpty && input instanceof String) {
			String value = (String) input;
			isEmpty = "".equals(value.trim());
		}

		if (!isEmpty && input instanceof Collection) {
			isEmpty = ((Collection<?>) input).isEmpty();
		}

		if (!isEmpty && input instanceof Map) {
			isEmpty = ((Map<?, ?>) input).isEmpty();
		}

		return isEmpty;
	}

}