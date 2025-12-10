import sys
import os

try:
    from pypdf import PdfReader
except ImportError:
    print("pypdf not installed")
    sys.exit(1)

def extract_text_from_pdf(pdf_path, output_path):
    try:
        reader = PdfReader(pdf_path)
        text = ""
        for page in reader.pages:
            text += page.extract_text() + "\n"
        
        with open(output_path, "w", encoding="utf-8") as f:
            f.write(text)
        print(f"Successfully extracted text to {output_path}")
    except Exception as e:
        print(f"Error extracting text: {e}")

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Usage: python extract_pdf.py <pdf_path> <output_path>")
        sys.exit(1)
    
    pdf_path = sys.argv[1]
    output_path = sys.argv[2]
    extract_text_from_pdf(pdf_path, output_path)
