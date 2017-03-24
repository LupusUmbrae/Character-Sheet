package org.moss.charactersheet.util;

import java.util.HashMap;
import java.util.Map;

import org.moss.charactersheet.interfaces.UpdateListener;
import org.moss.charactersheet.util.listeners.Direct;
import org.moss.charactersheet.util.listeners.ListenerHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListenerFactory {
    private static Map<Object, ListenerHandler> listeners = new HashMap<>();

    public static void registerListener(Object key, UpdateListener value) {
        if (!listeners.containsKey(key)) {
            log.warn("No caller has registered yet: " + key);
        }
        listeners.get(key).addListener(value);
    }

    public static void registerCaller(Object key) {
        log.trace("Registering caller: " + key);
        if (!listeners.containsKey(key)) {
            listeners.put(key, new Direct(key));
        }
    }

    public static void registerCaller(Object key, ListenerHandler handler) {
        log.trace("Registering caller: " + key);
        if (!listeners.containsKey(key)) {
            listeners.put(key, handler);
        }
    }

    public static void callback(Object key, Object value) {
        if (listeners.containsKey(key)) {
            listeners.get(key).updateListeners(value);
        }
    }
}
