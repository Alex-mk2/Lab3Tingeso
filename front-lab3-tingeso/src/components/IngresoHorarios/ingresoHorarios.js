import React, { useState } from "react";
import Axios from 'axios';
import NavBar from "../NavBar/NavBar";
import Swal from 'sweetalert2';
import { Typography, TextField, Button, Container, Box } from '@mui/material';

const AgregarHorario = () => {
  const [nuevoHorario, setNuevoHorario] = useState({
    bloque: null,
    codigoAsignatura: null,
    diaSemana: '',
    horaInicio: null,
    horaTermino: null,
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNuevoHorario({ ...nuevoHorario, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await Axios.post("http://localhost:8090/horarios", nuevoHorario);
      setNuevoHorario({
        bloque: null,
        codigoAsignatura: null,
        diaSemana: '',
        horaInicio: null,
        horaTermino: null,
      });

      Swal.fire("Éxito", "Horario agregado con éxito", "success");
    } catch (error) {
      console.error("Error al agregar el horario:", error);
      Swal.fire("Fallido", "Error al agregar el horario", "error");
    }
  };

  return (
    <Container>
      <NavBar />
      <Box mt={3}>
        <Typography variant="h5" gutterBottom>
          Agregar Horario estudiante
        </Typography>
        <form onSubmit={handleSubmit}>
          {/* Agregar campos del formulario */}
          <TextField
            label="Código Asignatura"
            name="codigoAsignatura"
            value={nuevoHorario.codigoAsignatura}
            onChange={handleInputChange}
            required
          />
          {/* Otros campos del formulario */}
          <TextField
            label="Bloque asignatura"
            name="bloque"
            value={nuevoHorario.bloque}
            onChange={handleInputChange}
            required
          />
          <TextField
            label="Día semana"
            name="diaSemana"
            value={nuevoHorario.diaSemana}
            onChange={handleInputChange}
          />
          <TextField
            label="Hora inicio"
            name="horaInicio"
            value={nuevoHorario.horaInicio}
            onChange={handleInputChange}
            required
          />
          <TextField
            label="Hora termino"
            name="horaTermino"
            value={nuevoHorario.horaTermino}
            onChange={handleInputChange}
            required
          />
          <Button type="submit" variant="contained" color="primary">
            Agregar Horario
          </Button>
        </form>
      </Box>
    </Container>
  );
};

export default AgregarHorario;
