package com.Crisalis.demo.service;

import com.Crisalis.demo.exception.custom.NotFoundException;
import com.Crisalis.demo.model.*;
import com.Crisalis.demo.model.DTO.ClienteDTO;
import com.Crisalis.demo.model.DTO.DetalleDTO;
import com.Crisalis.demo.model.DTO.PedidoDTO;
import com.Crisalis.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoDetalleRepository pedidoDetalleRepository;
    private final ClienteRepository clienteRepository;
    private final EmpresaRepository empresaRepository;
    private final PersonRepository personRepository;
    private final ProductoRepository productoRepository;
    private final ServicioRepository servicioRepository;
    private final Calculos calculos;
    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, PedidoDetalleRepository pedidoDetalleRepository,
                         ClienteRepository clienteRepository, EmpresaRepository empresaRepository, PersonRepository personRepository, ProductoRepository productoRepository, ServicioRepository servicioRepository, Calculos calculos)
    {
        this.pedidoRepository = pedidoRepository;
        this.pedidoDetalleRepository = pedidoDetalleRepository;
        this.clienteRepository = clienteRepository;
        this.empresaRepository = empresaRepository;
        this.personRepository = personRepository;
        this.productoRepository = productoRepository;
        this.servicioRepository = servicioRepository;
        this.calculos = calculos;
    }
    //CRUD
    public List<Pedido> listar(){
        return this.pedidoRepository.findAll();
    }
    public List<PedidoDTO> allPedidos(){
        return this.pedidoRepository
                .findAll()
                .stream()
                .map(PedidoDTO::toDto)
                .collect(Collectors.toList());
    }
    /*public List<DetalleDTO> findAll()
    {
        List<Pedido> pedidos = pedidoRepository.findAll();
        if(pedidos.isEmpty()){
            throw new NotFoundException("Pedidos no encontrados");
        }
        List<DetalleDTO> pedidoDetalleDtoList = pedidos
                .stream()
                .map(pedido -> PedidoDTO.pedidoDetalleToDto(pedido, null))
                .collect(Collectors.toList());
        return pedidoDetalleDtoList;
    }*/
    /*public List<PedidoDTO> findByClient(String identification)
    {
        List<PedidoDTO> pedidoDTOLista = new ArrayList<>();
        List<Pedido> pedidoLista = this.pedidoRepository.findByClient(this.clienteRepository
                .findByIdenfication(identification).orElseThrow(
                        () -> new RuntimeException("Cliente no encontrado")
                ));
        for(Pedido pedido : pedidoLista)
        {
            pedidoDTOLista.add(pedido.toDTO());
        }
        return pedidoDTOLista;
    }*/

    public PedidoDTO add(PedidoDTO pedido) {
        Optional<Empresa> empresa = null;
        ClienteDTO persona = null;
        ClienteDTO clienteDTO = null;
        if (pedido.getEmpresa() != null) {
            empresa = this.empresaRepository.findById(pedido.getEmpresa().getId());
        } else if (pedido.getPersona() != null) {
            Optional<Person> personas = this.personRepository.findById(pedido.getPersona().getId());
            persona = persona.personaToDto(personas);
        }
        /*PedidoDTO PedidoCreado = this.pedidoRepository.save
                (new PedidoDTO(null, null, null, null,
                        null, null, null, null,
                        persona, null, null));*/

        for (Pedido_detalle iterator : pedido.getPedido_detalle()) {
            Optional<Producto> producto = null;
            Optional<Servicio> servicio = null;
            //Optional<Pedido_detalle> detalle = null;
            BigDecimal precioUnitario = BigDecimal.valueOf(0);
            BigDecimal precioTotal = BigDecimal.valueOf(0);
            BigDecimal descuento = BigDecimal.valueOf(0);
            BigDecimal garantia = BigDecimal.valueOf(0);
            BigDecimal porcentajeGarantia = BigDecimal.valueOf(0);
            if (iterator.getProducto() != null) {
                producto = this.productoRepository.findById(iterator.getProducto().getBien_ID());
                precioUnitario = this.calculos.calcularPrecioUnitario(producto.get(), null);
                porcentajeGarantia = producto.get().getProd_PorcentajeGarantia();
            } else if (iterator.getServicio() != null) {
                servicio = this.servicioRepository.findById(iterator.getServicio().getBien_ID());
                precioUnitario = this.calculos.calcularPrecioUnitario(null, servicio.get());
                porcentajeGarantia = null;
            }

           /* DetalleDTO detalles = this.pedidoDetalleRepository.save
                    (new DetalleDTO(null, iterator.getItem_cant(),
                            precioUnitario, null, null, null, porcentajeGarantia, PedidoCreado));*/
        }
        //precioTotal = this.calculos.calcularSubTotal(detalle.get());
        //descuento = this.calculos.calcularDescuentoTotal(detalle.get());
        //garantia = this.calculos.calcularGarantiaTotal(detalle.get());
        ;/*pedido.getPedido_detalle().add(this.pedidoDetalleRepository.findById(iterator).orElseThrow(
                    () -> new RuntimeException("Detalle Orden no encontrado")*/

        return null;
    }
        /*pedido.setCliente(this.clienteRepository.findByIdenficationNumber(clienteId).orElseThrow(
                () -> new RuntimeException("Cliente no encontrado")
        ));
        return this.pedidoRepository.save(pedido.toPedidoEntity());
    }*/
        public void anular (Integer id)
        {
            Optional<Pedido> pedido = pedidoRepository.findById(id);
            if(pedido.isPresent()){
                Pedido pedidoAnulado = pedido.get();
                pedidoAnulado.setEstado(false);
                pedidoRepository.save(pedidoAnulado);
            } else {
                throw new NotFoundException("Pedido con ID " +id+" no existe");
            }
        }

/*
    //Logica de Negocio

    public Pedido getHistorialPedidos(ClienteDTO cliente, BienDTO servicio, BienDTO producto, PedidoDTO fecha) {

        return null;
    }

    public Pedido mayorDescuento(){
        return null;
    }

    public Pedido calcularDescTotales(){
        return null;
    }*/
}