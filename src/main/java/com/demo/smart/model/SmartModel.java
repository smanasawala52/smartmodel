package com.demo.smart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "smart_feature")
public class SmartModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9100570969474344406L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	List<SmartFeature> smartFeatures = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	List<CommonModel> services = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	List<CommonModel> devices = new ArrayList<>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the services
	 */
	public List<CommonModel> getServices() {
		return services;
	}

	/**
	 * @param services
	 *            the services to set
	 */
	public void setServices(List<CommonModel> services) {
		this.services = services;
	}

	/**
	 * @return the devices
	 */
	public List<CommonModel> getDevices() {
		return devices;
	}

	/**
	 * @param devices
	 *            the devices to set
	 */
	public void setDevices(List<CommonModel> devices) {
		this.devices = devices;
	}

	/**
	 * @return the smartFeatures
	 */
	public List<SmartFeature> getSmartFeatures() {
		return smartFeatures;
	}

	/**
	 * @param smartFeatures
	 *            the smartFeatures to set
	 */
	public void setSmartFeatures(List<SmartFeature> smartFeatures) {
		this.smartFeatures = smartFeatures;
	}

}
