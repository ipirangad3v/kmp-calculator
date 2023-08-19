//
//  ComposeView.swift
//  iosApp
//
//  Created by Anthoni on 19/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

struct ComposeView: UIViewControllerRepresentable{
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
    func makeUIViewController(context: Context) -> some UIViewController {
        MainViewControllerKt.MainViewController()
        
    }
}

