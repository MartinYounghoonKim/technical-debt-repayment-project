import { createContext } from "react";

const ProfileContext = createContext({});

export const ProfilePrivider = ProfileContext.Provider;

export const ProfileConsumer = ProfileContext.Consumer;
