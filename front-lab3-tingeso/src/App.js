import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Inicio from "./components/Inicio/inicio";
import IngresoHorario from "./components/IngresoHorarios/ingresoHorarios";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" Component={Inicio} />
        <Route path="/ingresoHorarios" Component={IngresoHorario}></Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
