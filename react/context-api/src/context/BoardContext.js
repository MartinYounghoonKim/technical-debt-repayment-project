import { createContext } from "react";

const BoardContext = createContext({});
const { Provider, Consumer } = BoardContext;

export {
  Provider as BoardProvider,
  Consumer as BoardContext
}
