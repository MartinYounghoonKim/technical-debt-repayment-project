import React from "react";
import { BoardContext } from "./context/BoardContext";

const BoardDetails = () => (
  <BoardContext>
    {({ index, title, content }) => (
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{index}</td>
            <td>{title}</td>
            <td>{content}</td>
          </tr>
        </tbody>
      </table>
    )}
  </BoardContext>
);

export default BoardDetails;
