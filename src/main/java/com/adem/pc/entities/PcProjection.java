package com.adem.pc.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPcl", types = { Pc.class })
public interface PcProjection {
	public String getNomPc();
}
