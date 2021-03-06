/*
 * Copyright (c) 2017 igu.io. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.igu.networkrail.model.model

import io.igu.networkrail.exception.TransactionCategoryNotFoundException

object TrainCategory extends Enumeration {
  type TrainCategory = Value
  val LONDON_UNDERGROUND_METRO_SERVICE,
  UNADVERTISED_ORDINARY_PASSENGER,
  ORDINARY_PASSENGER,
  STAFF_TRAIN,
  MIXED,
  CHANNEL_TUNNEL,
  SLEEPER_EUROPE_NIGHT_SERVICES,
  INTERNATIONAL,
  MOTORAIL,
  UNADVERTISED_EXPRESS,
  EXPRESS_PASSENGER,
  SLEEPER_DOMESTIC,
  BUS_REPLACEMENT,
  BUS_WTT_SERVICE,
  SHIP,
  EMPTY_COACHING_STOCK,
  ECS_LONDON_UNDERGROUND_METRO_SERVICE,
  ECS_STAFF,
  POSTAL,
  POST_OFFICE_CONTROLLED_PARCELS,
  PARCELS,
  EMPTY_NPCCS,
  DEPARTMENTAL_TRAINS,
  CIVIL_ENGINEER,
  MECHANICAL_AND_ELECTRICAL_ENGINEER,
  STORES,
  TEST,
  SIGNAL_AND_TELECOMMUNICATIONS_ENGINEER,
  LOCOMOTIVE_AND_BRAKE_VAN,
  LIGHT_LOCOMOTIVES,
  RFD_AUTOMOTIVE_COMPONENTS,
  RFD_AUTOMOTIVE_VEHICLES,
  RFD_BUILDING_MATERIALS_UK_CONTRACTS,
  RFD_CHEMICALS_UK_CONTRACT,
  RFD_EDIBLE_PRODUCTS_UK_CONTRACTS,
  RFD_FREIGHTLINER_CONTRACTS,
  RFD_FREIGHTLINER_OTHER,
  RFD_EUROPEAN,
  RFD_GENERAL_MERCHANDISE_UK_CONTRACTS,
  RFD_INDUSTRIAL_MINERALS_UK_CONTRACTS,
  COAL_DISTRIBUTIVE,
  COAL_ELECTRICITY_MGR,
  COAL_OTHER_AND_NUCLEAR,
  METALS,
  AGGREGATES,
  DOMESTIC_AND_INDUSTRIAL_WASTE,
  BUILDING_MATERIALS_TLF,
  PETROLEUM_PRODUCTS,
  RFD_EUROPEAN_CHANNEL_TUNNEL_MIXED_BUSINESS,
  RFD_EUROPEAN_CHANNEL_TUNNEL_INTERMODAL,
  RFD_EUROPEAN_CHANNEL_TUNNEL_AUTOMOTIVE,
  RFD_EUROPEAN_CHANNEL_TUNNEL_CONTRACT_SERVICES,
  RFD_EUROPEAN_CHANNEL_TUNNEL_HAULMARK,
  RFD_EUROPEAN_CHANNEL_TUNNEL_JOINT_VENTURE = Value

  def parse(str: String): TrainCategory = str match {
    case "OL" => LONDON_UNDERGROUND_METRO_SERVICE
    case "OU" => UNADVERTISED_ORDINARY_PASSENGER
    case "OO" => ORDINARY_PASSENGER
    case "OS" => STAFF_TRAIN
    case "OW" => MIXED
    case "XC" => CHANNEL_TUNNEL
    case "XD" => SLEEPER_EUROPE_NIGHT_SERVICES
    case "XI" => INTERNATIONAL
    case "XR" => MOTORAIL
    case "XU" => UNADVERTISED_EXPRESS
    case "XX" => EXPRESS_PASSENGER
    case "XZ" => SLEEPER_DOMESTIC
    case "BR" => BUS_REPLACEMENT
    case "BS" => BUS_WTT_SERVICE
    case "SS" => SHIP
    case "EE" => EMPTY_COACHING_STOCK
    case "EL" => ECS_LONDON_UNDERGROUND_METRO_SERVICE
    case "ES" => ECS_STAFF
    case "JJ" => POSTAL
    case "PM" => POST_OFFICE_CONTROLLED_PARCELS
    case "PP" => PARCELS
    case "PV" => EMPTY_NPCCS
    case "DD" => DEPARTMENTAL_TRAINS
    case "DH" => CIVIL_ENGINEER
    case "DI" => MECHANICAL_AND_ELECTRICAL_ENGINEER
    case "DQ" => STORES
    case "DT" => TEST
    case "DY" => SIGNAL_AND_TELECOMMUNICATIONS_ENGINEER
    case "ZB" => LOCOMOTIVE_AND_BRAKE_VAN
    case "ZZ" => LIGHT_LOCOMOTIVES
    case "J2" => RFD_AUTOMOTIVE_COMPONENTS
    case "H2" => RFD_AUTOMOTIVE_VEHICLES
    case "J6" => RFD_BUILDING_MATERIALS_UK_CONTRACTS
    case "J5" => RFD_CHEMICALS_UK_CONTRACT
    case "J3" => RFD_EDIBLE_PRODUCTS_UK_CONTRACTS
    case "J9" => RFD_FREIGHTLINER_CONTRACTS
    case "H9" => RFD_FREIGHTLINER_OTHER
    case "H8" => RFD_EUROPEAN
    case "J8" => RFD_GENERAL_MERCHANDISE_UK_CONTRACTS
    case "J4" => RFD_INDUSTRIAL_MINERALS_UK_CONTRACTS
    case "A0" => COAL_DISTRIBUTIVE
    case "E0" => COAL_ELECTRICITY_MGR
    case "B0" => COAL_OTHER_AND_NUCLEAR
    case "B1" => METALS
    case "B4" => AGGREGATES
    case "B5" => DOMESTIC_AND_INDUSTRIAL_WASTE
    case "B6" => BUILDING_MATERIALS_TLF
    case "B7" => PETROLEUM_PRODUCTS
    case "H0" => RFD_EUROPEAN_CHANNEL_TUNNEL_MIXED_BUSINESS
    case "H1" => RFD_EUROPEAN_CHANNEL_TUNNEL_INTERMODAL
    case "H3" => RFD_EUROPEAN_CHANNEL_TUNNEL_AUTOMOTIVE
    case "H4" => RFD_EUROPEAN_CHANNEL_TUNNEL_CONTRACT_SERVICES
    case "H5" => RFD_EUROPEAN_CHANNEL_TUNNEL_HAULMARK
    case "H6" => RFD_EUROPEAN_CHANNEL_TUNNEL_JOINT_VENTURE
    case unknown => throw new TransactionCategoryNotFoundException(unknown)
  }
}