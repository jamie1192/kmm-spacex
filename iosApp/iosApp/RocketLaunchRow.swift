//
//  RocketLaunchRow.swift
//  iosApp
//
//  Created by Jamie Astley on 16/5/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketLaunchRow: View {
    var rocketLaunch: RocketLaunch
    
    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0) {
                Text("Launch name: \(rocketLaunch.missionName)")
                Text(launchText).foregroundColor(launchColor)
                Text("Launch year: \(String(rocketLaunch.launchYear))")
                Text("Launch details: \(rocketLaunch.details ?? "")")
            }
            Spacer()
        }
    }
}

extension RocketLaunchRow {
    private var launchText: String {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? "Successful" : "Unsuccessful"
        } else {
            return "No data"
        }
    }
    
    private var launchColor: Color {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? Color.green : Color.red
        } else {
            return Color.gray
        }
    }
}

struct RocketLaunchRow_Previews: PreviewProvider {
    static var previews: some View {
        RocketLaunchRow(
            rocketLaunch: RocketLaunch(
                flightNumber: 1,
                missionName: "Dummy mission",
                launchYear: 2020,
                launchDateUTC: "2020/12/01T12:00:00Z",
                rocket: Rocket(
                    id: "1",
                    name: "Rocket name",
                    type: "Rocket type"
                ),
                details: "Some details",
                launchSuccess: true,
                links: Links(missionPatchUrl: "www.google.com", articleUrl: "")
            )
        )
    }
}
