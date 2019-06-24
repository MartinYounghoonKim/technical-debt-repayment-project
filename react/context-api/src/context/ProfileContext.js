import { createContext } from "react";

const ProfileContext = createContext({
  name: "Irene",
  age: "18"
});

export const ProfileProvider = ProfileContext.Provider;

export const ProfileConsumer = ProfileContext.Consumer;
