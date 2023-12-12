import React, { useState } from "react";
import Axios from 'axios';
import NavBar from "../NavBar/NavBar";
import Swal from 'sweetalert2';
import { Typography, TextField, Button, Container, Box } from '@mui/material';

const AgregarHorario = () => {
  const [nuevoHorario, setNuevoHorario] = useState({
    bloque: '',
    codigoAsignatura: '',
    diaSemana: '',
    horaInicio: '',
    horaTermino: '',
    nombreAsignatura: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNuevoHorario({ ...nuevoHorario, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    // Validar que el día seleccionado no sea sábado ni domingo
    const diaSeleccionado = nuevoHorario.diaSemana.toLowerCase(); // Convertir a minúsculas
    console.log("Día seleccionado:", diaSeleccionado); // Agrega esta línea para imprimir el valor


    // Validar la diferencia de horarios
    const minutosInicio = parseInt(nuevoHorario.horaInicio.substr(0, 2)) * 60 + parseInt(nuevoHorario.horaInicio.substr(2, 2));
    const minutosTermino = parseInt(nuevoHorario.horaTermino.substr(0, 2)) * 60 + parseInt(nuevoHorario.horaTermino.substr(2, 2));
    const diferenciaHorarios = minutosTermino - minutosInicio;

    if(diferenciaHorarios < 0 || diferenciaHorarios > 180) {
      Swal.fire("Error", "La diferencia de horarios debe ser entre 0 y 180 minutos", "error");
      return;
    }else if(diferenciaHorarios <= 2){
      Swal.fire("Error", "No es posible que el horario sea ese, es muy corto", "error");
      return;
    }
  
    if(diaSeleccionado === 'sabado' || diaSeleccionado === 'domingo') {
      Swal.fire("Error", "Los horarios no están permitidos los sábados ni domingos", "error");
      return;
    }
  
    try {
      await Axios.post("http://localhost:8090/horarios", nuevoHorario);
      setNuevoHorario({
        bloque: '',
        codigoAsignatura: '',
        diaSemana: '',
        horaInicio: '',
        horaTermino: '',
        nombreAsignatura: '',
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
          <TextField
            label="nombre asignatura"
            name="nombreAsignatura"
            value={nuevoHorario.nombreAsignatura}
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
