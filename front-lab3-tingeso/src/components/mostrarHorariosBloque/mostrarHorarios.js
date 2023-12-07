import React, { useEffect, useState } from "react";
import Axios from 'axios';
import NavBar from "../NavBar/NavBar";
import { Typography, Container, Box, Card, CardContent } from '@mui/material';

const MostrarHorariosBloque = () => {
  const [eventosMostrar, setEventosMostrar] = useState([]);

  useEffect(() => {
    const obtenerHorarios = async () => {
      try {
        const response = await Axios.get("http://localhost:8090/horarios");
        setEventosMostrar(response.data);
      } catch (error) {
        console.error("Error al obtener los horarios:", error);
      }
    };

    obtenerHorarios();
  }, []);

  const asignarColor = (bloque) => {
    switch (bloque) {
      case 1:
        return "#F6F4EB";
      case 2:
        return "#91C8E4";
      case 3:
        return "#749BC2"; 
      case 4:
        return "#4682A9";
      case 5:
        return "#29ADB2";
      default:
        return "#333"; 
    }
  };

  const ordenarPorDia = (eventos) => {
    return eventos.sort((a, b) => {
      const diasOrden = ['lunes', 'martes', 'miercoles', 'jueves', 'viernes'];
      const ordenDiasA = diasOrden.indexOf(a.diaSemana.toLowerCase());
      const ordenDiasB = diasOrden.indexOf(b.diaSemana.toLowerCase());
      if (ordenDiasA !== ordenDiasB) {
        return ordenDiasA - ordenDiasB;
      }
      return a.bloque - b.bloque;
    });
  };

  const limitarBloques = (eventos, maxBloques) => {
    const bloquesPorDia = {};
    
    eventos.forEach((evento) => {
      if (!bloquesPorDia[evento.diaSemana]) {
        bloquesPorDia[evento.diaSemana] = [];
      }

      if (bloquesPorDia[evento.diaSemana].length < maxBloques) {
        bloquesPorDia[evento.diaSemana].push(evento);
      }
    });

    const eventosLimitados = Object.values(bloquesPorDia).flat();

    return ordenarPorDia(eventosLimitados);
  };

  const eventosLimitados = limitarBloques(eventosMostrar, 5); 
 
  const eventosPorDia = eventosLimitados.reduce((acc, evento) => {
    if (!acc[evento.diaSemana]) {
      acc[evento.diaSemana] = [];
    }
    acc[evento.diaSemana].push(evento);
    return acc;
  }, {});

  return (
    <Container>
      <NavBar />
      <Box mt={3}>
        <Typography variant="h5" gutterBottom>
          Mostrar Horarios por Bloque
        </Typography>
        {Object.entries(eventosPorDia).map(([dia, eventosDia]) => (
          <div key={dia}>
            <Typography variant="h6" gutterBottom>
              {`${dia.charAt(0).toUpperCase()}${dia.slice(1)}`}
            </Typography>
            <div style={{ display: "flex" }}>
              {eventosDia.map((evento, index) => (
                <Card
                  key={evento.id}
                  style={{ 
                    backgroundColor: asignarColor(evento.bloque), 
                    width: "200px",
                    height: "180px",
                    marginLeft: index > 0 ? "8px" : "0",
                  }}
                >
                  <CardContent>
                    <Typography variant="h6">
                      Asignatura: {evento.nombreAsignatura}
                    </Typography>
                    <Typography>
                      Bloque: {evento.bloque}, Día: {evento.diaSemana}
                    </Typography>
                    <Typography>
                      Hora Inicio: {evento.horaInicio}, Hora Término: {evento.horaTermino}
                    </Typography>
                  </CardContent>
                </Card>
              ))}
            </div>
          </div>
        ))}
        {eventosLimitados.length === 0 && <p>No hay horarios para mostrar.</p>}
      </Box>
    </Container>
  );
};

export default MostrarHorariosBloque;

