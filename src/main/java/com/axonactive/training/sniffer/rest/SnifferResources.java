/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axonactive.training.sniffer.rest;

import com.axonactive.training.sniffer.data.bom.Sniffer;
import com.axonactive.training.sniffer.service.restricted.SnifferServices;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author nvmuon
 */
@Stateless
@Path("sniffers")
public class SnifferResources {
    
    @EJB SnifferServices snifferServices;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
    public Response save(Sniffer sniffer) {
        snifferServices.save(snifferServices.toEntity(sniffer));
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
    public List<Sniffer> readAll() {
        return snifferServices.toBoms(snifferServices.findAll());
    }
    
    @GET
    @Path("{code}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
    public Sniffer read(@PathParam("code")String productCode) {
        return snifferServices.toBom(snifferServices.findByCode(productCode));
    }
    
    @DELETE
    @Path("{code}")
    public Response deleteByCode(@PathParam("code")String productCode) {
        this.snifferServices.deleteByCode(productCode);
        return Response.ok().build();
    }
}
