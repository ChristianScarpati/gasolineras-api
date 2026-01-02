package com.gasolineras.api.service;

import com.gasolineras.api.client.MockGasStationsClient;
import com.gasolineras.api.model.GasStation;
import org.junit.jupiter.api.Test; // Librería JUnit 5
import java.util.List;

import static org.junit.jupiter.api.Assertions.*; // Para validar resultados

class GasStationServiceTest {

    @Test
    void testGetNearestGasStations() {
        // 1. PREPARAR (Arrange)
        // Usamos el Mock que ya creamos
        MockGasStationsClient mockClient = new MockGasStationsClient();
        GasStationServices service = new GasStationServices(mockClient);

        // 2. EJECUTAR (Act)
        // Pedimos gasolineras a 50km de Madrid (esperamos encontrar 2)
        List<GasStation> result = service.getNearestStations(40.416775, -3.703790, 50.0);

        // 3. VERIFICAR (Assert) - Aquí la máquina comprueba por nosotros
        assertNotNull(result, "La lista no debería ser nula");
        assertEquals(2, result.size(), "Debería encontrar 2 gasolineras en este radio");

        // Verificamos que la primera es la más cercana ("GASOLINERA NORTE")
        assertEquals("North Gasoil", result.get(0).getName());
    }
}