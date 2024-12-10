'use client';

import Link from 'next/link';

const LandingPage = () => {
    return (
        <div className="min-h-screen bg-gray-100 flex items-center justify-center">
            <div className="text-center">
                <h1 className="text-4xl font-bold mb-6">Welcome to MyCargonaut</h1>
                <p className="text-gray-600 mb-4">
                    Share rides and freight easily with our community-driven platform.
                </p>
                <div className="space-x-4">
                    <Link
                        href="search"
                        className="bg-blue-500 text-white px-6 py-3 rounded hover:bg-blue-600"
                    >
                        Get Started
                    </Link>
                    <Link
                        href="register"
                        className="bg-gray-500 text-white px-6 py-3 rounded hover:bg-gray-600"
                    >
                        Sign Up
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default LandingPage;
